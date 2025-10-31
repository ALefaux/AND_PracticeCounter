package fr.alefaux.practicecounter.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import fr.alefaux.practicecounter.core.navigation.FeaturesDestinations
import fr.alefaux.practicecounter.core.navigation.LocalNavHostController
import fr.alefaux.practicecounter.core.navigation.MainRootView
import fr.alefaux.practicecounter.feature.home.presentation.HomeScreen
import fr.alefaux.practicecounter.feature.practice.add.presentation.AddPracticeScreen
import fr.alefaux.practicecounter.feature.practice.add.presentation.AddPracticeViewModel
import fr.alefaux.practicecounter.feature.practice.detail.presentation.PracticeDetailScreen
import fr.alefaux.practicecounter.feature.practice.detail.presentation.PracticeDetailViewModel

@Composable
fun MainHostView() {
    MainRootView {
        NavHost(
            modifier =
                Modifier
                    .fillMaxSize(),
            navController = LocalNavHostController.current,
            startDestination = FeaturesDestinations.Home.constructFinalRoute(),
        ) {
            composable(
                route = FeaturesDestinations.Home.constructTemplateRoute()
            ) {
                HomeScreen()
            }

            composable(
                route = FeaturesDestinations.Practice.Add.constructTemplateRoute(),
                arguments = listOf(
                    navArgument(FeaturesDestinations.Practice.Add.PARAM_ID) {
                        defaultValue = null
                        nullable = true
                    }
                )
            ) {
                val viewModel: AddPracticeViewModel = hiltViewModel()
                AddPracticeScreen(viewModel)
            }

            composable(
                route = FeaturesDestinations.Practice.Detail.constructTemplateRoute()
            ) {
                val viewModel: PracticeDetailViewModel = hiltViewModel()
                PracticeDetailScreen(viewModel)
            }
        }
    }
}
