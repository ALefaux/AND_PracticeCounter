package fr.alefaux.practicecounter.feature.practice.list.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PracticeListScreen(
    modifier: Modifier = Modifier,
    viewModel: PracticeListViewModel = viewModel()
) {
    PracticeListState(
        modifier = modifier,
        state = viewModel.state.collectAsStateWithLifecycle().value
    )
}