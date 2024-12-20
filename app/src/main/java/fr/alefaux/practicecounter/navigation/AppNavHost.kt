package fr.alefaux.practicecounter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier
) = NavHost(
    modifier = modifier,
    navController = rememberNavController(),
    startDestination = AppDestinations.Home.ROOT
) {
    homeNavigation()
}