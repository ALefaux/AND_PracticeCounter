package fr.alefaux.practicecounter.feature.home.pane

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme
import fr.alefaux.practicecounter.feature.home.ui.AddFloatingActionButton

@Composable
fun HomeFloatingsPane(
    onAddPracticeClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AddFloatingActionButton(
        modifier = modifier,
        onClick = onAddPracticeClicked,
    )
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun HomeFloatingsPanePreview() {
    AppTheme {
        HomeFloatingsPane(
            onAddPracticeClicked = {},
        )
    }
}
