package fr.alefaux.practicecounter.feature.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.feature.home.pane.HomePane

@Composable
fun HomeScreen(
    onAddClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    HomePane(
        modifier = modifier,
        onAddClicked = onAddClicked
    )
}