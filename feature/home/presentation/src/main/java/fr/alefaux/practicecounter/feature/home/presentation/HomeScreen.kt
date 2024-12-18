package fr.alefaux.practicecounter.feature.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.feature.home.panes.HomePane

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    HomePane(
        modifier = modifier
    )
}