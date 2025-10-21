package fr.alefaux.practicecounter.core.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeCounterTopBar(
    title: String,
    modifier: Modifier = Modifier
) {
    MediumTopAppBar(
        modifier = modifier,
        title = {
            Text(text = title)
        },
    )
}
