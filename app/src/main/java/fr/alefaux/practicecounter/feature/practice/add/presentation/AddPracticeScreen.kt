package fr.alefaux.practicecounter.feature.practice.add.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.alefaux.practicecounter.feature.practice.add.pane.AddPracticePane
import fr.alefaux.practicecounter.feature.practice.add.ui.AddPracticeTopBar
import kotlinx.coroutines.launch

@Composable
fun AddPracticeScreen(
    modifier: Modifier = Modifier,
    viewModel: AddPracticeViewModel = hiltViewModel(),
    onBackClicked: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var errorMessageAlert: String? by remember { mutableStateOf(null) }

    LaunchedEffect(key1 = "Listen for error message") {
        viewModel.event.collect { event ->
            when (event) {
                is AddPracticeEvent.Error -> errorMessageAlert = event.message
                is AddPracticeEvent.Created -> scope.launch {
                    snackbarHostState.showSnackbar("Activité créée")
                }
            }
        }
    }

    if (!errorMessageAlert.isNullOrBlank()) {
        AlertDialog(
            icon = {
                Icon(
                    imageVector = Icons.TwoTone.Warning,
                    contentDescription = null
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
                    }
                ) {
                    Text("Fermer")
                }
            }
        )
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            AddPracticeTopBar(
                onBackClicked = onBackClicked
            )
        }
    ) { innerPadding ->
        AddPracticePane(
            modifier = modifier.padding(innerPadding),
            objective = viewModel.objective,
            onBackClicked = onBackClicked,
            onCreateClicked = viewModel::onCreateClicked,
            onObjectiveChanged = viewModel::onObjectiveChanged,
            onTitleChanged = viewModel::onTitleChanged,
            title = viewModel.title
        )
    }
}