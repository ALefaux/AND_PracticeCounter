package fr.alefaux.practicecounter.feature.practice.detail.panes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.core.components.LoadingScreen
import fr.alefaux.practicecounter.feature.practice.detail.modelui.PracticeDetailState

@Composable
fun PracticeDetailStatePane(
    state: PracticeDetailState,
    modifier: Modifier = Modifier
) {
    when (state) {
        PracticeDetailState.Loading -> LoadingScreen(
            modifier = modifier
        )
        is PracticeDetailState.Success -> {
            PracticeDetailSuccessPane(
                modifier = modifier,
                objective = state.objective,
                seances = state.seancesUi
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