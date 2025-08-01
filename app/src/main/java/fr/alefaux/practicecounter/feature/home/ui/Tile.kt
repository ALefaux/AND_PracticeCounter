package fr.alefaux.practicecounter.feature.home.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun Tile(
    objective: Int?,
    onDeleteClicked: () -> Unit,
    number: Int,
    title: String,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    onTileClicked: () -> Unit
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
                onClick = onTileClicked
            ),
            border = border,
        ) {
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
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
                }
                Text(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.headlineMedium,
                    text = number.toString(),
                )
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
private fun TileNeutralPreview() {
    AppTheme {
        Surface(
            modifier = Modifier,
        ) {
            Tile(
                modifier = Modifier.fillMaxWidth(),
                number = 3,
                objective = 25,
                title = "Title of tile",
                onDeleteClicked = {}
            ) {}
        }
    }
}
