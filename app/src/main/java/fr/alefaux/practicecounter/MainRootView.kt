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
import fr.alefaux.practicecounter.core.components.PracticeCounterTopBarInfo
import fr.alefaux.practicecounter.core.designsystem.theme.AppTheme
import fr.alefaux.practicecounter.core.utils.navigation.LocalNavHostController
import fr.alefaux.practicecounter.core.utils.navigation.LocalSnackbarHostState
import fr.alefaux.practicecounter.core.utils.navigation.LocalTopBarInfo

@Composable
fun MainRootView(
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val topBarInfo = remember { PracticeCounterTopBarInfo() }

    CompositionLocalProvider(
        LocalNavHostController provides rememberNavController(),
        LocalSnackbarHostState provides snackbarHostState,
        LocalTopBarInfo provides topBarInfo
    ) {
        AppTheme {
            Scaffold(
                modifier = modifier,
                content = content,
                snackbarHost = {
                    SnackbarHost(snackbarHostState)
                },
                topBar = {
                    topBarInfo.title?.let { title ->
                        PracticeCounterTopBar(
                            title = title
                        )
                    }
                },
            )
        }
    }
}
