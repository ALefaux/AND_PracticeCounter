package fr.alefaux.practicecounter.feature.practice.add.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.alefaux.practicecounter.feature.practice.add.domain.CreatePracticeUseCase
import fr.alefaux.practicecounter.feature.practice.add.domain.model.AddPractice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AddPracticeViewModel
    @Inject
    constructor(
        private val createPracticeUseCase: CreatePracticeUseCase,
    ) : ViewModel() {
        var objective: String by mutableStateOf("")
            private set

        var title: String by mutableStateOf("")
            private set

        private var _event: MutableSharedFlow<AddPracticeEvent> = MutableSharedFlow()
        val event: SharedFlow<AddPracticeEvent> = _event

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
                        // TODO Go back to home
                        Timber.d("Successfully created practice")
                        title = ""
                        objective = ""
                        withContext(Dispatchers.Main) {
                            _event.emit(AddPracticeEvent.Created)
                        }
                    }.onFailure { error ->
                        Timber.w(error, "Error while creating practice")
                        _event.emit(AddPracticeEvent.Error("Error while creating practice"))
                    }
                } else {
                    _event.emit(AddPracticeEvent.Error("Please fill all fields"))
                }
            }
        }

        fun onObjectiveChanged(newObjective: String) {
            objective = newObjective
        }

        fun onTitleChanged(newTitle: String) {
            title = newTitle
        }

        private fun canCreatePractice(): Boolean = title.isNotBlank() && (objective.isBlank() || objective.toIntOrNull() != null)
    }
