package fr.alefaux.practicecounter.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.alefaux.practicecounter.core.navigation.AppRoutes
import fr.alefaux.practicecounter.core.navigation.LocalNavHostController
import fr.alefaux.practicecounter.core.navigation.MainRootView
import fr.alefaux.practicecounter.feature.home.presentation.HomeScreen
import fr.alefaux.practicecounter.feature.practice.add.presentation.AddPracticeScreen
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
            startDestination = AppRoutes.Home.constructFinalRoute(),
        ) {
            composable(AppRoutes.Home.constructTemplateRoute()) {
                HomeScreen()
            }

            composable(AppRoutes.Practice.Add.constructTemplateRoute()) {
                AddPracticeScreen()
            }

            composable(AppRoutes.Practice.Detail.constructTemplateRoute()) {
                val viewModel: PracticeDetailViewModel = hiltViewModel()
                PracticeDetailScreen(viewModel)
            }
        }
    }
}
