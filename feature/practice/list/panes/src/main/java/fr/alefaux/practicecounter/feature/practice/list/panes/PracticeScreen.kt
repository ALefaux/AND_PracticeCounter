package fr.alefaux.practicecounter.feature.practice.list.panes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.feature.practice.list.modelui.PracticeUi

@Composable
fun PracticeScreen(
    practices: List<PracticeUi>,
    modifier: Modifier = Modifier
) {
    PracticeList(
        modifier = modifier,
        onPracticeClicked = { practice -> },
        practices = practices
    )
}