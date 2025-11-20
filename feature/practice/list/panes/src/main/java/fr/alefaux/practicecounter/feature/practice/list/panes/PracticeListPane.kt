package fr.alefaux.practicecounter.feature.practice.list.panes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.feature.practice.list.modelui.PracticeUi
import kotlinx.collections.immutable.ImmutableList

@Composable
fun PracticeListPane(
    onDeletePracticeClick: (PracticeUi) -> Unit,
    onPracticeClick: (PracticeUi) -> Unit,
    practices: ImmutableList<PracticeUi>,
    modifier: Modifier = Modifier,
) {
    PracticeList(
        modifier = modifier,
        onDeleteClick = onDeletePracticeClick,
        onPracticeClick = onPracticeClick,
        practices = practices,
    )
}
