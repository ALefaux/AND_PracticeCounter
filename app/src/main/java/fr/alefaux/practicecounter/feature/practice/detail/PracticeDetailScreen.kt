package fr.alefaux.practicecounter.feature.practice.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PracticeDetailScreen(
    id: Int,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = "Practice Detail Screen #$id"
    )
}