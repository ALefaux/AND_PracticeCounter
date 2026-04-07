package fr.alefaux.practicecounter.practice.list.ui

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun OldPracticeItem(
    lastExercise: String?,
    objective: Int?,
    onDeleteClicked: () -> Unit,
    title: String,
    todayExercise: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var isMenuExpanded: Boolean by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
    ) {
        Card(
            modifier = Modifier.combinedClickable(
                enabled = true,
                onLongClick = {
                    isMenuExpanded = true
                },
                onClick = onClick
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.headlineSmall,
                    text = title,
                )
                objective?.let {
                    Text(
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        style = MaterialTheme.typography.bodyMedium,
                        text = "Objectif: $objective",
                    )
                }
                if (todayExercise > 0) {
                    Text(
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        style = MaterialTheme.typography.bodyLarge,
                        text = "Aujourd'hui : $todayExercise",
                    )
                } else {
                    lastExercise?.let {
                        Text(
                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                            style = MaterialTheme.typography.bodyMedium,
                            text = "Dernier exercice: $lastExercise",
                        )
                    }
                }
            }
        }
        DropdownMenu(
            expanded = isMenuExpanded,
            onDismissRequest = {
                isMenuExpanded = false
            }
        ) {
            DropdownMenuItem(
                text = {
                    Text("Delete")
                },
                onClick = onDeleteClicked
            )
        }
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun OldPracticeItemPreview() {
    AppTheme {
        OldPracticeItem(
            modifier = Modifier.width(300.dp),
            lastExercise = "22/03/2025",
            objective = 12,
            onClick = {},
            onDeleteClicked = {},
            title = "Push-up",
            todayExercise = 2
        )
    }
}
