package fr.alefaux.practicecounter.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.alefaux.practicecounter.MainRootView
import fr.alefaux.practicecounter.core.utils.navigation.LocalNavHostController
import fr.alefaux.practicecounter.feature.home.presentation.HomeScreen
import fr.alefaux.practicecounter.feature.practice.add.presentation.AddPracticeScreen

@Composable
fun MainHostView() {
    MainRootView { innerPadding ->
        val navController = LocalNavHostController.current

        NavHost(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
            navController = navController,
            startDestination = AppRoutes.Home.constructFinalRoute(),
        ) {
            composable(AppRoutes.Home.constructTemplateRoute()) {
                HomeScreen()
            }

            composable(AppRoutes.Practice.Add.constructTemplateRoute()) {
                AddPracticeScreen()
            }
        }
    }
}
