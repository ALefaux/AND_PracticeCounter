package fr.alefaux.practicecounter.core.navigation

sealed interface FeaturesDestinations :
    Route,
    RouteTemplate {
    data object Home : FeaturesDestinations, Route, RouteTemplate {
        override val template: RouteTemplate = this

        override fun constructTemplateRoute(): String = "app/home"
    }

    sealed interface Practice : FeaturesDestinations, Route, RouteTemplate {
        data object Add : Practice, Route, RouteTemplate {
            override val template: RouteTemplate = this
            const val PARAM_ID = "id"

            override fun constructTemplateRoute(): String = "app/practice/add/{$PARAM_ID}"
            override fun constructFinalRoute(): String = constructRoute(null)

            fun constructRoute(id: Int?): String = "app/practice/add/$id"
        }

        data object Detail : Practice, Route, RouteTemplate {
            override val template: RouteTemplate = this
            const val PARAM_ID = "id"

            override fun constructTemplateRoute(): String = "app/practice/detail/{$PARAM_ID}"

            fun constructRoute(id: Int): String = "app/practice/detail/$id"
        }
    }
}