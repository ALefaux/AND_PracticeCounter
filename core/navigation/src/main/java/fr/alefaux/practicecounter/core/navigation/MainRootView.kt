package fr.alefaux.practicecounter.core.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainRootView(
    content: @Composable () -> Unit
) {
    val navController = rememberNavController()
    var itemSelected: AppDestinations by remember { mutableStateOf(AppDestinations.HOME) }

    CompositionLocalProvider(
        LocalNavHostController provides navController,
    ) {
        AppTheme {
            NavigationSuiteScaffold(
                navigationSuiteItems = {
                    AppDestinations.entries.forEach { destination ->
                        item(
                            selected = itemSelected == destination,
                            onClick = {
                                itemSelected = destination

                                when (destination) {
                                    AppDestinations.HOME -> FeaturesDestinations.Home.constructFinalRoute()
                                    AppDestinations.LIST -> FeaturesDestinations.Practice.List.constructFinalRoute()
                                }.also { route ->
                                    navController.navigate(
                                        route = route,
                                        navOptions = navOptions {
                                            popUpTo(navController.graph.startDestinationId) {
                                                inclusive = true
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    )
                                }
                            },
                            label = {
                                Text(
                                    text = stringResource(destination.label)
                                )
                            },
                            icon = {
                                Icon(
                                    destination.icon,
                                    contentDescription = stringResource(destination.contentDescription),
                                )
                            }
                        )
                    }
                }
            ) {
                content()
            }
        }
    }
}
