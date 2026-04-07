package fr.alefaux.practicecounter.practice.list.ui.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun PracticeItemCount(
    count: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        PracticeItemTodayNumber(
            count = count
        )
        PracticeItemTodayTitle()
    }
}

@Composable
@PreviewLightDark
private fun PracticeItemCountPreview() {
    AppTheme {
        PracticeItemCount(count = 10)
    }
}