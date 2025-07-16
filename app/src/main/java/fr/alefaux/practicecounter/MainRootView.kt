package fr.alefaux.practicecounter

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
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme
import fr.alefaux.practicecounter.core.utils.navigation.LocalNavHostController
import fr.alefaux.practicecounter.core.utils.navigation.LocalSnackbarHostState

@Composable
fun MainRootView(
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }

    CompositionLocalProvider(
        LocalNavHostController provides rememberNavController(),
        LocalSnackbarHostState provides snackbarHostState
    ) {
        AppTheme {
            Scaffold(
                modifier = modifier,
                content = content,
                snackbarHost = {
                    SnackbarHost(snackbarHostState)
                },
                topBar = {
                    PracticeCounterTopBar()
                },
            )
        }
    }
}
