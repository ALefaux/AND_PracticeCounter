package fr.alefaux.practicecounter.feature.practice.add.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.twotone.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import fr.alefaux.practicecounter.core.components.PracticeCounterTopBarInfo
import fr.alefaux.practicecounter.core.utils.navigation.LocalNavHostController
import fr.alefaux.practicecounter.core.utils.navigation.LocalSnackbarHostState
import fr.alefaux.practicecounter.core.utils.navigation.LocalTopBarInfo
import fr.alefaux.practicecounter.feature.practice.add.pane.AddPracticePane
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun AddPracticeScreen(
    modifier: Modifier = Modifier,
    navController: NavController = LocalNavHostController.current,
    viewModel: AddPracticeViewModel = hiltViewModel(),
) {
    val snackbarHostState = LocalSnackbarHostState.current
    val scope = rememberCoroutineScope()
    var errorMessageAlert: String? by remember { mutableStateOf(null) }

    LaunchedEffect(key1 = "Listen for error message") {
        viewModel.event.collect { event ->
            when (event) {
                is AddPracticeEvent.Error -> errorMessageAlert = event.message
                is AddPracticeEvent.Created -> {
                    scope.launch {
                        snackbarHostState.showSnackbar("Activité créée")
                        navController.navigateUp()
                    }
                }
            }
        }
    }

    if (!errorMessageAlert.isNullOrBlank()) {
        AlertDialog(
            icon = {
                Icon(
                    imageVector = Icons.TwoTone.Warning,
                    contentDescription = null,
                )
            },
            title = {
                Text(text = "Impossible d'enregistrer la pratique")
            },
            text = {
                Text(text = errorMessageAlert ?: "")
            },
            onDismissRequest = {
                errorMessageAlert = null
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        errorMessageAlert = null
                    },
                ) {
                    Text("Fermer")
                }
            },
        )
    }

    CompositionLocalProvider(
        LocalTopBarInfo provides
                PracticeCounterTopBarInfo(
                    title = "Ajouter une pratique",
                ),
    ) {
        Column {
            IconButton(
                onClick = navController::navigateUp,
            ) {
                Icon(
                    contentDescription = null,
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                )
            }
            AddPracticePane(
                modifier = modifier,
                objective = viewModel.objective,
                onBackClicked = {
                    navController.navigateUp()
                },
                onCreateClicked = viewModel::onCreateClicked,
                onObjectiveChanged = viewModel::onObjectiveChanged,
                onTitleChanged = viewModel::onTitleChanged,
                title = viewModel.title,
            )
        }
    }
}
