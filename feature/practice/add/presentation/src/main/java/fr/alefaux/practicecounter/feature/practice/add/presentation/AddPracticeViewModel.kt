package fr.alefaux.practicecounter.feature.practice.add.presentation

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.alefaux.practicecounter.core.model.Result
import fr.alefaux.practicecounter.core.navigation.FeaturesDestinations
import fr.alefaux.practicecounter.feature.practice.add.domain.CreatePracticeUseCase
import fr.alefaux.practicecounter.feature.practice.add.domain.GetPracticeByIdUseCase
import fr.alefaux.practicecounter.feature.practice.add.domain.UpdatePracticeUseCase
import fr.alefaux.practicecounter.feature.practice.add.domain.model.AddPractice
import fr.alefaux.practicecounter.feature.practice.add.presentation.model.AddPracticeEvent
import fr.alefaux.practicecounter.feature.practice.add.modelui.ScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AddPracticeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val createPracticeUseCase: CreatePracticeUseCase,
    private val getPracticeByIdUseCase: GetPracticeByIdUseCase,
    private val updatePracticeUseCase: UpdatePracticeUseCase
) : ViewModel() {
    var objective: String by mutableStateOf("")
        private set

    var title: String by mutableStateOf("")
        private set

    val event: SharedFlow<AddPracticeEvent>
        field = MutableSharedFlow()

    private val id: String? = savedStateHandle[FeaturesDestinations.Practice.Add.PARAM_ID]
    val screenState by derivedStateOf {
        if (id.isNullOrBlank()) {
            ScreenState.Creating
        } else if (id.isNotBlank() && title.isBlank()) {
            loadPractice()
            ScreenState.MustBeLoaded
        } else {
            ScreenState.Updating
        }
    }

    private fun loadPractice() {
        id?.toIntOrNull()?.let { practiceId ->
            viewModelScope.launch(Dispatchers.IO) {
                runCatching {
                    getPracticeByIdUseCase(practiceId)
                }.onSuccess { result ->
                    when (result) {
                        is Result.Success -> {
                            with(result.value) {
                                this@AddPracticeViewModel.title = title
                                this@AddPracticeViewModel.objective = objective.toString()
                            }
                        }
                        else -> {
                            Timber.w("Couldn't load practice #$practiceId")
                        }
                    }
                }.onFailure {
                    Timber.w("Couldn't load practice")
                }
            }
        }
    }

    fun onCreateClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            if (canCreatePractice()) {
                runCatching {
                    createPracticeUseCase(
                        AddPractice(
                            title = title,
                            objective = objective.toIntOrNull(),
                        ),
                    )
                }.onSuccess {
                    Timber.d("Successfully created practice")
                    title = ""
                    objective = ""
                    withContext(Dispatchers.Main) {
                        event.emit(AddPracticeEvent.Created)
                    }
                }.onFailure { error ->
                    Timber.w(error, "Error while creating practice")
                    event.emit(AddPracticeEvent.Error("Error while creating practice"))
                }
            } else {
                event.emit(AddPracticeEvent.Error("Please fill all fields"))
            }
        }
    }

    fun onUpdateClicked() {
        id?.toIntOrNull()?.let { practiceId ->
            viewModelScope.launch(Dispatchers.IO) {
                runCatching {
                    updatePracticeUseCase(
                        id = practiceId,
                        objective = objective.toIntOrNull(),
                    )
                }.onSuccess {
                    withContext(Dispatchers.Main) {
                        event.emit(AddPracticeEvent.Updated)
                    }
                }.onFailure {
                    Timber.w(it, "Error while updating practice")
                    event.emit(AddPracticeEvent.Error("Error while updating practice"))
                }
            }
        }
    }

    fun onObjectiveChanged(newObjective: String) {
        objective = newObjective
    }

    fun onTitleChanged(newTitle: String) {
        title = newTitle
    }

    private fun canCreatePractice(): Boolean =
        title.isNotBlank() && (objective.isBlank() || objective.toIntOrNull() != null)
}
