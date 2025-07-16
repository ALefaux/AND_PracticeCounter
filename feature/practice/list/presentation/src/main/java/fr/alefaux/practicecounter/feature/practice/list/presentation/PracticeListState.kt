package fr.alefaux.practicecounter.feature.practice.list.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.feature.practice.list.panes.PracticeListPane
import fr.alefaux.practicecounter.feature.practice.list.presentation.model.PracticeListUiState

@Composable
fun PracticeListState(
    state: PracticeListUiState,
    modifier: Modifier = Modifier,
) {
    when (state) {
        is PracticeListUiState.Loading -> {}
        is PracticeListUiState.Success -> {
            PracticeListPane(
                modifier = modifier,
                practices = state.practices,
            )
        }
    }
}
