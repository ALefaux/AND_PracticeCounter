package fr.alefaux.practicecounter.feature.home.panes

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import fr.alefaux.practicecounter.core.designsystem.theme.PracticeCounterTheme
import fr.alefaux.practicecounter.feature.home.ui.Tile

@Composable
fun HomePane(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Tile()
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun HomePanePreview() {
    PracticeCounterTheme {
        HomePane()
    }
}