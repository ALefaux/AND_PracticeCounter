package fr.alefaux.practicecounter.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost() {
    NavHost(
        modifier = Modifier
            .fillMaxSize(),
        navController = rememberNavController(),
        startDestination = AppDestinations.Home.ROOT
    ) {
        homeNavigation(
            onAddClicked = {}
        )
    }
}