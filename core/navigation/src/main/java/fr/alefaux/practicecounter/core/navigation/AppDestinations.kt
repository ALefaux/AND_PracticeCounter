package fr.alefaux.practicecounter.core.navigation

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
