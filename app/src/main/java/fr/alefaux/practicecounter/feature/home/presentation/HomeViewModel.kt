package fr.alefaux.practicecounter.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.alefaux.practicecounter.feature.home.domain.GetHomeDataUseCase
import fr.alefaux.practicecounter.feature.home.domain.model.Practice
import fr.alefaux.practicecounter.feature.home.modelui.HomeUiState
import fr.alefaux.practicecounter.feature.home.modelui.PracticeUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getHomeDataUseCase: GetHomeDataUseCase,
    ) : ViewModel() {
        private var _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState.Loading)
        val uiState: StateFlow<HomeUiState> = _uiState

        private val dateNow: Date = Calendar.getInstance().time

        init {
            fetchHomeData()
        }

        private fun fetchHomeData() {
            viewModelScope.launch(Dispatchers.IO) {
                getHomeDataUseCase(dateNow)
                    .catch { error ->
                        Timber.w(error, "Error while fetching home data")
                    }.collect { homeData ->
                        Timber.d("Successfully fetched home data")
                        val isEmpty: Boolean = homeData.practicesOfTheDay.isEmpty()
                        Timber.d("HomeData::isEmpty? $isEmpty")

                        _uiState.update {
                            if (isEmpty) {
                                HomeUiState.Empty
                            } else {
                                HomeUiState.Success(
                                    practicesOfTheDay = homeData.practicesOfTheDay.map { it.toUi() },
                                )
                            }
                        }
                    }
            }
        }

        private fun Practice.toUi(): PracticeUi =
            PracticeUi(
                id = id ?: 0,
                objective = objective,
                number = seances.sumOf { it.number },
                title = title,
            )
    }
