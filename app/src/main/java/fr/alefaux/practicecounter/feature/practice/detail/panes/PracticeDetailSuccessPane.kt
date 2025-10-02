package fr.alefaux.practicecounter.feature.practice.detail.panes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PracticeDetailSuccessPane(
    objective: Int?,
    seances: List<String>,
    modifier: Modifier = Modifier
) {
    objective?.let {
        Text(
            modifier = modifier,
            text = "Objectif : $objective"
        )
    }
    seances.forEach {
        Text(
            modifier = modifier,
            text = it
        )
    }
}