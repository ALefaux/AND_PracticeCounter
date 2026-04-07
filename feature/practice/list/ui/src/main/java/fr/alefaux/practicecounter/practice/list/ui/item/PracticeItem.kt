package fr.alefaux.practicecounter.practice.list.ui.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun PracticeItem(
    practiceCount: Int,
    practiceLastTime: String,
    practiceName: String,
    practiceProgress: Float,
    modifier: Modifier = Modifier,
    practiceIcon: ImageVector = Icons.Default.FitnessCenter,
    onAddClick: () -> Unit
) {
    PracticeItemCard(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Icon practice
                PracticeItemIcon(
                    icon = practiceIcon
                )
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    // Title
                    PracticeItemTitle(
                        title = practiceName
                    )
                    PracticeItemCount(
                        count = practiceCount
                    )
                }
                // Add button
                PracticeItemAddButton(
                    onAddClick = onAddClick
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                PracticeItemLastTime(
                    modifier = Modifier.weight(2f),
                    lastTime = practiceLastTime
                )
                PracticeItemProgressBar(
                    modifier = Modifier.weight(1f),
                    progress = practiceProgress
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
private fun PracticeItemPreview() {
    AppTheme {
        PracticeItem(
            practiceCount = 45,
            practiceIcon = Icons.Default.FitnessCenter,
            practiceLastTime = "24M AGO",
            practiceName = "Pushups",
            practiceProgress = 0.66f
        ) {}
    }
}