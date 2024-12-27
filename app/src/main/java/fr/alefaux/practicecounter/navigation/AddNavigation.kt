package fr.alefaux.practicecounter.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import fr.alefaux.practicecounter.feature.add.presentation.AddPracticeScreen

fun NavGraphBuilder.addNavigation(
    navController: NavHostController
) {
    navigation(
        route = AppDestinations.Add.ROOT,
        startDestination = AppDestinations.Add.ROUTE
    ) {
        composable(
            route = AppDestinations.Add.ROUTE
        ) {
            AddPracticeScreen {
                navController.navigateUp()
            }
        }
    }
}