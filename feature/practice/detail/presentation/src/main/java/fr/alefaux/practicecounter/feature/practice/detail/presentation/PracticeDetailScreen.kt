package fr.alefaux.practicecounter.feature.practice.detail.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import fr.alefaux.practicecounter.core.navigation.FeaturesDestinations
import fr.alefaux.practicecounter.core.navigation.LocalNavHostController
import fr.alefaux.practicecounter.feature.practice.detail.panes.DeleteConfirmationDialog
import fr.alefaux.practicecounter.feature.practice.detail.panes.PracticeDetailStatePane
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeDetailScreen(
    viewModel: PracticeDetailViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = LocalNavHostController.current
) {
    var title: String by remember { mutableStateOf("") }
    val openDeleteConfirmationDialog = remember { mutableStateOf(false) }

    LaunchedEffect("listen to title updates") {
        viewModel.title.collect {
            Timber.d("title updated: $it")
            title = it
        }
    }

    LaunchedEffect("listen to delete practice") {
        viewModel.deletePractice.collect {
            navController.navigateUp()
        }
    }

    if (openDeleteConfirmationDialog.value) {
        DeleteConfirmationDialog(
            onDismiss = {
                openDeleteConfirmationDialog.value = false
            },
            onConfirm = {
                openDeleteConfirmationDialog.value = false
                viewModel.deletePractice()
            },
            practiceName = title
        )
    }

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = {
                    Icon(
                        contentDescription = null,
                        imageVector = Icons.TwoTone.Add
                    )
                },
                onClick = {},
                text = {
                    Text(
                        text = "Ajouter une séance"
                    )
                }
            )
        },
        topBar = {
            TopAppBar(
                actions = {
                    IconButton(
                        onClick = {
                            openDeleteConfirmationDialog.value = true
                        }
                    ) {
                        Icon(
                            contentDescription = null,
                            imageVector = Icons.TwoTone.Delete
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(
                            contentDescription = null,
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        )
                    }
                },
                title = {
                    Text(
                        text = title
                    )
                }
            )
        }
    ) { innerPadding ->
        PracticeDetailStatePane(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onEditClick = {
                navController.navigate(
                    route = FeaturesDestinations.Practice.Add.constructRoute(
                        id = viewModel.id.toInt()
                    )
                )
            },
            state = viewModel.state.collectAsStateWithLifecycle().value
        )
    }
}