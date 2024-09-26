package fr.alefaux.practicecounter.practice.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import fr.alefaux.practicecounter.core.designsystem.theme.PracticeCounterTheme

@Composable
fun PracticeItem(
    modifier: Modifier = Modifier,
) {

}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun PracticeItemPreview() {
    PracticeCounterTheme {
        PracticeItem()
    }
}