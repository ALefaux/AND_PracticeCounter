package fr.alefaux.practicecounter.feature.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import fr.alefaux.practicecounter.core.navigation.LocalNavHostController
import fr.alefaux.practicecounter.core.navigation.FeaturesDestinations
import fr.alefaux.practicecounter.feature.home.pane.HomeState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController = LocalNavHostController.current,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = {
                    Icon(
                        contentDescription = null,
                        imageVector = Icons.TwoTone.Add
                    )
                },
                onClick = {
                    navController.navigate(
                        route = FeaturesDestinations.Practice.Add.constructFinalRoute(),
                    )
                },
                text = {
                    Text(
                        text = "Ajouter une activité",
                    )
                }
            )
        },
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
        HomeState(
            modifier = Modifier.padding(innerPadding),
            onDeleteClicked = { id ->
                viewModel.deletePractice(id)
            },
            onPracticeClicked = { id ->
                navController.navigate(FeaturesDestinations.Practice.Detail.constructRoute(id))
            },
            state = viewModel.uiState.collectAsStateWithLifecycle().value,
        )
    }
}
