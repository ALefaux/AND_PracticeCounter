package fr.alefaux.practicecounter.feature.practice.list.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import fr.alefaux.practicecounter.core.components.PracticeCounterTopBar

@Composable
fun PracticeListScreen(
    modifier: Modifier = Modifier,
    viewModel: PracticeListViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            PracticeCounterTopBar(
                title = "Vos activités"
            )
        }
    ) { innerPadding ->
        PracticeListState(
            modifier = Modifier.padding(innerPadding),
            state = viewModel.state.collectAsStateWithLifecycle().value,
        )
    }
}
