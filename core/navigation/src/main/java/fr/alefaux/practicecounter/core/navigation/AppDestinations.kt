package fr.alefaux.practicecounter.core.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.List
import androidx.compose.material.icons.twotone.Home
import androidx.compose.ui.graphics.vector.ImageVector
import fr.alefaux.practicecounter.core.localisation.R as CoreLocalisationR

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
