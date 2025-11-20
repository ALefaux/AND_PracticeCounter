package fr.alefaux.practicecounter.feature.practice.list.panes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme
import fr.alefaux.practicecounter.feature.practice.list.modelui.PracticeUi
import fr.alefaux.practicecounter.practice.list.ui.PracticeItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun PracticeList(
    onDeleteClick: (PracticeUi) -> Unit,
    onPracticeClick: (PracticeUi) -> Unit,
    practices: ImmutableList<PracticeUi>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(practices) { practice ->
            PracticeItem(
                lastExercise = practice.lastExercise,
                objective = practice.objective,
                onClick = {
                    onPracticeClick(practice)
                },
                onDeleteClicked = {
                    onDeleteClick(practice)
                },
                title = practice.name,
                todayExercise = practice.todayExercise,
            )
        }
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun PracticeListPreview() {
    AppTheme {
        PracticeList(
            onPracticeClick = {},
            onDeleteClick = {},
            practices =
                List(8) {
                    PracticeUi(
                        id = 1,
                        lastExercise = null,
                        objective = 12,
                        name = "Push-up",
                        todayExercise = 2
                    )
                }.toImmutableList()
        )
    }
}
