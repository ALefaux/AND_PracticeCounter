package fr.alefaux.practicecounter.feature.practice.add.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun ObjectiveField(
    onValueChanged: (String) -> Unit,
    value: String,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        onValueChange = { text ->
            onValueChanged(text)
        },
        placeholder = {
            Text("Objectif")
        },
        value = value
    )
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun ObjectiveFieldPreview() {
    AppTheme {
        Surface {
            ObjectiveField(
                onValueChanged = {},
                value = ""
            )
        }
    }
}