package fr.alefaux.practicecounter.core.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.core.utils.navigation.LocalTopBarInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeCounterTopBar(modifier: Modifier = Modifier) {
    val info = LocalTopBarInfo.current

    MediumTopAppBar(
        modifier = modifier,
        title = {
            Text(text = info.title)
        },
    )
}
