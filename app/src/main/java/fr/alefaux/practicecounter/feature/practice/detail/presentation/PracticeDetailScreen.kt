package fr.alefaux.practicecounter.feature.practice.detail.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import fr.alefaux.practicecounter.core.utils.navigation.LocalNavHostController
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

    LaunchedEffect("listen to title updates") {
        viewModel.title.collect {
            Timber.d("title updated: $it")
            title = it
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            MediumTopAppBar(
                actions = {
                    IconButton(
                        onClick = {}
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
            state = viewModel.state.collectAsStateWithLifecycle().value
        )
    }
}