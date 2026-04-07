package fr.alefaux.practicecounter.feature.practice.list.panes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme
import fr.alefaux.practicecounter.feature.practice.list.modelui.PracticeUi
import fr.alefaux.practicecounter.practice.list.ui.item.PracticeItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun PracticeList(
    onDeleteClick: (PracticeUi) -> Unit,
    onPracticeClick: (PracticeUi) -> Unit,
    practices: ImmutableList<PracticeUi>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(practices) { practice ->
            PracticeItem(
                practiceCount = practice.todayExercise,
                practiceLastTime = practice.lastExercise ?: "",
                practiceName = practice.name,
                practiceProgress = practice.todayExercise.toFloat() / (practice.objective ?: 0),
                onAddClick = {
                    onPracticeClick(practice)
                }
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
