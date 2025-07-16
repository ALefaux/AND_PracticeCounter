package fr.alefaux.practicecounter.feature.practice.add.ui

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun CreateButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ElevatedButton(
        modifier = modifier,
        onClick = onClick,
        content = {
            Text(text = "Créer")
        },
    )
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun CreateButtonPreview() {
    AppTheme {
        Surface {
            CreateButton(
                onClick = {},
            )
        }
    }
}
