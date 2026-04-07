package fr.alefaux.practicecounter.practice.list.ui.item

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun PracticeItemTodayTitle(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = "TODAY",
        color = Color.Gray,
        fontSize = 14.sp
    )
}

@Composable
@PreviewLightDark
private fun PracticeItemTodayTitlePreview() {
    AppTheme {
        PracticeItemTodayTitle()
    }
}