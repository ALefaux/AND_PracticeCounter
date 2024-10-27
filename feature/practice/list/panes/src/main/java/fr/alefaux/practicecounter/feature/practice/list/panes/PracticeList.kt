package fr.alefaux.practicecounter.feature.practice.list.panes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.PracticeCounterTheme
import fr.alefaux.practicecounter.feature.practice.list.modelui.PracticeUi
import fr.alefaux.practicecounter.practice.list.ui.PracticeItem

@Composable
fun PracticeList(
    onPracticeClicked: (PracticeUi) -> Unit,
    practices: List<PracticeUi>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(practices) { practice ->
            PracticeItem(
                name = practice.name,
                onClick = {
                    onPracticeClicked(practice)
                }
            )
        }
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun PracticeListPreview() {
    PracticeCounterTheme {
        PracticeList(
            onPracticeClicked = {},
            practices = listOf(
                PracticeUi("Push-up"),
                PracticeUi("Squat"),
                PracticeUi("Burpees"),
                PracticeUi("Push-up"),
                PracticeUi("Squat"),
                PracticeUi("Burpees"),
                PracticeUi("Push-up"),
                PracticeUi("Squat")
            )
        )
    }
}