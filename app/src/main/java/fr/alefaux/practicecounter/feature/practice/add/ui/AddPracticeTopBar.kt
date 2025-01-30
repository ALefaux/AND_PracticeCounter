package fr.alefaux.practicecounter.feature.practice.add.ui

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPracticeTopBar(
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable {
                    onBackClicked()
                },
                contentDescription = null,
                imageVector = Icons.AutoMirrored.TwoTone.ArrowBack
            )
        },
        title = {
            Text(
                text = "Ajouter une pratique"
            )
        }
    )
}