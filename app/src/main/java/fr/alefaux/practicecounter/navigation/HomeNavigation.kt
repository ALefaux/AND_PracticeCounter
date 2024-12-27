package fr.alefaux.practicecounter.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import fr.alefaux.practicecounter.feature.home.presentation.HomeScreen

fun NavGraphBuilder.homeNavigation(
    navController: NavHostController
) {
    navigation(
        route = AppDestinations.Home.ROOT,
        startDestination = AppDestinations.Home.ROUTE
    ) {
        composable(
            route = AppDestinations.Home.ROUTE
        ) {
            HomeScreen(
                onAddClicked = {
                    navController.navigate(AppDestinations.Add.ROOT)
                }
            )
        }
    }
}