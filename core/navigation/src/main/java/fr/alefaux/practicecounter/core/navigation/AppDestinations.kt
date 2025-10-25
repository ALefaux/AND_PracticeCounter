package fr.alefaux.practicecounter.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.List
import androidx.compose.material.icons.twotone.Home
import androidx.compose.ui.graphics.vector.ImageVector
import fr.alefaux.practicecounter.core.localisation.R as CoreLocalisationR

sealed interface AppRoutes :
    Route,
    RouteTemplate {
    data object Home : AppRoutes, Route, RouteTemplate {
        override val template: RouteTemplate = this

        override fun constructTemplateRoute(): String = "app/home"
    }

    sealed interface Practice : AppRoutes, Route, RouteTemplate {
        data object Add : Practice, Route, RouteTemplate {
            override val template: RouteTemplate = this

            override fun constructTemplateRoute(): String = "app/practice/add"
        }

        data object Detail : Practice, Route, RouteTemplate {
            override val template: RouteTemplate = this
            const val PARAM_ID = "id"

            override fun constructTemplateRoute(): String = "app/practice/detail/{$PARAM_ID}"

            fun constructRoute(id: Int): String = "app/practice/detail/$id"
        }
    }
}

enum class AppDestinations(
    @param:StringRes val label: Int,
    val icon: ImageVector,
    @param:StringRes val contentDescription: Int
) {
    HOME(
        label = CoreLocalisationR.string.menu_home,
        icon = Icons.TwoTone.Home,
        contentDescription = CoreLocalisationR.string.menu_home_description
    ),
    LIST(
        label = CoreLocalisationR.string.menu_list,
        icon = Icons.AutoMirrored.TwoTone.List,
        contentDescription = CoreLocalisationR.string.menu_list_description
    ),
}
