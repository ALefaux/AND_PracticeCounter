package fr.alefaux.practicecounter.feature.practice.list.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import fr.alefaux.practicecounter.core.components.PracticeCounterTopBar
import fr.alefaux.practicecounter.core.navigation.FeaturesDestinations
import fr.alefaux.practicecounter.core.navigation.LocalNavHostController

@Composable
fun PracticeListScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = LocalNavHostController.current,
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
            onDeletePracticeClick = {},
            onPracticeClick = { practice ->
                navController.navigate(
                    route = FeaturesDestinations.Practice.Detail.constructRoute(practice.id)
                )
            },
            state = viewModel.state.collectAsStateWithLifecycle().value,
        )
    }
}
