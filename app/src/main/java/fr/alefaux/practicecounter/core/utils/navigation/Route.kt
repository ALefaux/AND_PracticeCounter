package fr.alefaux.practicecounter.core.utils.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import fr.alefaux.practicecounter.core.components.PracticeCounterTopBarInfo

val LocalNavHostController = compositionLocalOf<NavHostController> { error("No NavController provided") }
val LocalSnackbarHostState = compositionLocalOf<SnackbarHostState> { error("No SnackbarHostState provided") }
val LocalTopBarInfo =
    compositionLocalOf {
        PracticeCounterTopBarInfo(
            title = "",
        )
    }

interface RouteTemplate {
    fun constructTemplateRoute(): String
}

interface Route {
    val template: RouteTemplate

    fun constructFinalRoute(): String = template.constructTemplateRoute()
}
