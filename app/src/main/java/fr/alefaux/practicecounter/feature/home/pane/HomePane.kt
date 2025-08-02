package fr.alefaux.practicecounter.feature.home.pane

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme
import fr.alefaux.practicecounter.feature.home.modelui.PracticeUi
import fr.alefaux.practicecounter.feature.home.modelui.mock.mockPracticeUi
import fr.alefaux.practicecounter.feature.home.ui.Tile

@Composable
fun HomePane(
    onDeleteClicked: (practiceId: Int) -> Unit,
    onPracticeClicked: (practiceId: Int) -> Unit,
    practicesOfTheDay: List<PracticeUi>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(practicesOfTheDay) { practice ->
                Tile(
                    modifier = Modifier.fillMaxWidth(),
                    objective = practice.objective,
                    onDeleteClicked = {
                        onDeleteClicked(practice.id)
                    },
                    onTileClicked = {
                        onPracticeClicked(practice.id)
                    },
                    number = practice.number,
                    title = practice.title,
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun HomePanePreview() {
    AppTheme {
        HomePane(
            onDeleteClicked = {},
            onPracticeClicked = {},
            practicesOfTheDay = listOf(mockPracticeUi),
        )
    }
}
