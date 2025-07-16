package fr.alefaux.practicecounter.feature.home.pane

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.feature.home.modelui.HomeUiState

@Composable
fun HomeState(
    onPracticeClicked: (practiceId: Int) -> Unit,
    state: HomeUiState,
    modifier: Modifier = Modifier,
) {
    when (state) {
        is HomeUiState.Loading ->
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        is HomeUiState.Success ->
            HomePane(
                modifier = modifier,
                onPracticeClicked = onPracticeClicked,
                practicesOfTheDay = state.practicesOfTheDay,
            )
        is HomeUiState.Empty ->
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    style = MaterialTheme.typography.titleLarge,
                    text = "Aucun exercice à faire !",
                )
            }
    }
}
