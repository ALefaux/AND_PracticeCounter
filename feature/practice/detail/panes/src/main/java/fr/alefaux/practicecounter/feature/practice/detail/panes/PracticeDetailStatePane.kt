package fr.alefaux.practicecounter.feature.practice.detail.panes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.core.components.LoadingScreen
import fr.alefaux.practicecounter.feature.practice.detail.modelui.PracticeDetailState

@Composable
fun PracticeDetailStatePane(
    state: PracticeDetailState,
    modifier: Modifier = Modifier,
    onEditClick: () -> Unit
) {
    when (state) {
        PracticeDetailState.Loading -> LoadingScreen(
            modifier = modifier
        )
        is PracticeDetailState.Success -> {
            PracticeDetailSuccessPane(
                modifier = modifier,
                objective = state.objective,
                onEditClick = onEditClick,
                seances = state.seancesUi,
                seanceToday = state.seanceToday
            )
        }
        is PracticeDetailState.Error.NotFound -> {
            Text(
                modifier = modifier,
                text = "Not found"
            )
        }
        else -> {
            Text(
                modifier = modifier,
                text = "Error"
            )
        }
    }
}