package fr.alefaux.practicecounter.feature.home.panes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme
import fr.alefaux.practicecounter.feature.home.ui.Tile

@Composable
fun HomePane(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Tile(
            modifier = Modifier.fillMaxWidth(),
            title = "Pompe"
        )
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun HomePanePreview() {
    AppTheme {
        HomePane()
    }
}