package fr.alefaux.practicecounter.practice.list.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun PracticeItem(
    onClick: () -> Unit,
    name: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier =
            modifier
                .aspectRatio(1f)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                ).clickable {
                    onClick()
                },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            style = MaterialTheme.typography.displaySmall,
            text = name,
        )
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun PracticeItemPreview() {
    AppTheme {
        PracticeItem(
            modifier = Modifier.width(300.dp),
            onClick = {},
            name = "Push-up",
        )
    }
}
