package fr.alefaux.practicecounter.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import fr.alefaux.practicecounter.core.components.PracticeCounterTopBar
import fr.alefaux.practicecounter.core.components.PracticeCounterTopBarInfo
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme

@Composable
fun MainRootView(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalNavHostController provides rememberNavController(),
    ) {
        AppTheme {
            content()
        }
    }
}
