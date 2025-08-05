package fr.alefaux.practicecounter.feature.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import fr.alefaux.practicecounter.core.components.PracticeCounterTopBarInfo
import fr.alefaux.practicecounter.core.utils.navigation.LocalNavHostController
import fr.alefaux.practicecounter.core.utils.navigation.LocalTopBarInfo
import fr.alefaux.practicecounter.feature.home.pane.HomeState
import fr.alefaux.practicecounter.navigation.AppRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController = LocalNavHostController.current,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            MediumTopAppBar(
                title = {
                    Text(
                        text = "Activités du jour"
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            HomeState(
                modifier = Modifier.weight(1f),
                onDeleteClicked = { id ->
                    viewModel.deletePractice(id)
                },
                onPracticeClicked = { id ->
                    navController.navigate(AppRoutes.Practice.Detail.constructRoute(id))
                },
                state = viewModel.uiState.collectAsStateWithLifecycle().value,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Button(
                    modifier = Modifier.padding(16.dp),
                    onClick = {
                        navController.navigate(
                            route = AppRoutes.Practice.Add.constructTemplateRoute(),
                        )
                    },
                ) {
                    Text(
                        text = "Ajouter",
                    )
                }
            }
        }
    }
}
