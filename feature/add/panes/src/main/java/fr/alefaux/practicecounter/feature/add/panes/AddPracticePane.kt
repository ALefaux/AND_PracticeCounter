package fr.alefaux.practicecounter.feature.add.panes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme
import fr.alefaux.practicecounter.feature.add.ui.AddPracticeTopBar
import fr.alefaux.practicecounter.feature.add.ui.CreateButton
import fr.alefaux.practicecounter.feature.add.ui.ObjectiveField
import fr.alefaux.practicecounter.feature.add.ui.TitleField

@Composable
fun AddPracticePane(
    objective: String,
    onCreateClicked: () -> Unit,
    onObjectiveChanged: (String) -> Unit,
    onTitleChanged: (String) -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            AddPracticeTopBar(
                onBackClicked = onBackClicked
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TitleField(
                    onValueChanged = onTitleChanged,
                    value = title
                )
                ObjectiveField(
                    onValueChanged = onObjectiveChanged,
                    value = objective
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                CreateButton(
                    onClick = onCreateClicked
                )
            }
        }
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
                onCreateClicked = {},
                onObjectiveChanged = {},
                onTitleChanged = {},
                title = "Pompe"
            ) {}
        }
    }
}
