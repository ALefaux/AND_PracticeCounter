package fr.alefaux.practicecounter.feature.practice.add.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun TitleField(
    enabled: Boolean,
    onValueChanged: (String) -> Unit,
    value: String,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        onValueChange = { text ->
            onValueChanged(text)
        },
        placeholder = {
            Text(
                text = "Titre de l'activité",
            )
        },
        value = value,
    )
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun TitleFieldPreview() {
    AppTheme {
        Surface {
            TitleField(
                modifier = Modifier.padding(),
                enabled = true,
                onValueChanged = {},
                value = "",
            )
        }
    }
}
