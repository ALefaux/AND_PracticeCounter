package fr.alefaux.practicecounter.feature.practice.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
    objective: Int?,
    seanceToday: Int?,
    modifier: Modifier = Modifier,
    onEditClick: () -> Unit
) {
    Row(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
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
        IconButton(
            content = {
                Icon(
                    contentDescription = null,
                    imageVector = Icons.TwoTone.Edit
                )
            },
            onClick = onEditClick
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
        ) {}
    }
}