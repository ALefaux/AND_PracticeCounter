package fr.alefaux.practicecounter.feature.practice.detail.panes

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme
import fr.alefaux.practicecounter.feature.practice.detail.modelui.SeanceUi
import fr.alefaux.practicecounter.feature.practice.detail.ui.SeanceTodayAndObjective

@Composable
fun PracticeDetailSuccessPane(
    objective: Int?,
    seances: List<SeanceUi>,
    seanceToday: SeanceUi?,
    modifier: Modifier = Modifier,
    onEditClick: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        if (objective != null || seanceToday != null) {
            SeanceTodayAndObjective(
                objective = objective,
                onEditClick = onEditClick,
                seanceToday = seanceToday?.number
            )
        }
        seances.forEach {
            Text(
                text = "${it.date} : ${it.number}"
            )
        }
    }
}

@PreviewDynamicColors
@PreviewFontScale
@PreviewLightDark
@Composable
private fun PracticeDetailSuccessPanePreview() {
    AppTheme {
        PracticeDetailSuccessPane(
            objective = 10,
            seances = listOf(
                SeanceUi(
                    id = 1,
                    number = 5,
                    date = "16/10/2025"
                ),
                SeanceUi(
                    id = 0,
                    number = 3,
                    date = "14/10/2025"
                )
            ),
            seanceToday = null
        ) {}
    }
}