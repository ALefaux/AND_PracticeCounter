package fr.alefaux.practicecounter.feature.practice.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun SeanceTodayAndObjective(
    modifier: Modifier = Modifier,
    objective: Int?,
    seanceToday: Int?,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer
            )
            .padding(16.dp)
    ) {
        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = "Objectif : $objective"
        )
        Text(
            style = MaterialTheme.typography.titleLarge,
            text = "Seance du jour : ${seanceToday ?: "N/A"}"
        )
    }
}

@PreviewDynamicColors
@PreviewFontScale
@PreviewLightDark
@Composable
private fun SeanceTodayAndObjectivePreview() {
    AppTheme {
        SeanceTodayAndObjective(
            objective = 10,
            seanceToday = 5
        )
    }
}