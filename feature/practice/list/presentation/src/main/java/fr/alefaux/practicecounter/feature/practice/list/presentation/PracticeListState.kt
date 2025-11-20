package fr.alefaux.practicecounter.feature.practice.list.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.feature.practice.list.modelui.PracticeUi
import fr.alefaux.practicecounter.feature.practice.list.panes.PracticeListPane
import fr.alefaux.practicecounter.feature.practice.list.presentation.model.PracticeListUiState

@Composable
fun PracticeListState(
    onDeletePracticeClick: (PracticeUi) -> Unit,
    onPracticeClick: (PracticeUi) -> Unit,
    state: PracticeListUiState,
    modifier: Modifier = Modifier,
) {
    when (state) {
        is PracticeListUiState.Empty -> {}
        is PracticeListUiState.Loading -> {}
        is PracticeListUiState.Success -> {
            PracticeListPane(
                modifier = modifier,
                onDeletePracticeClick = onDeletePracticeClick,
                onPracticeClick = onPracticeClick,
                practices = state.practices,
            )
        }
    }
}
