package fr.alefaux.practicecounter.navigation

import fr.alefaux.practicecounter.core.utils.navigation.Route
import fr.alefaux.practicecounter.core.utils.navigation.RouteTemplate

internal sealed interface AppRoutes :
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

            override fun constructTemplateRoute(): String = "app/practice/detail"
        }
    }
}
