package fr.alefaux.practicecounter.feature.practice.add.panes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme
import fr.alefaux.practicecounter.feature.practice.add.modelui.ScreenState
import fr.alefaux.practicecounter.feature.practice.add.ui.ObjectiveField
import fr.alefaux.practicecounter.feature.practice.add.ui.TitleField

@Composable
fun AddPracticePane(
    objective: String,
    onObjectiveChanged: (String) -> Unit,
    onTitleChanged: (String) -> Unit,
    screenState: ScreenState,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        TitleField(
            enabled = screenState is ScreenState.Creating,
            onValueChanged = onTitleChanged,
            value = title,
        )
        ObjectiveField(
            enabled = screenState is ScreenState.Creating || screenState is ScreenState.Updating,
            onValueChanged = onObjectiveChanged,
            value = objective,
        )
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun AddPracticePanePreview() {
    AppTheme {
        Surface {
            AddPracticePane(
                objective = "50",
                onObjectiveChanged = {},
                onTitleChanged = {},
                screenState = ScreenState.Creating,
                title = "Pompe",
            )
        }
    }
}
