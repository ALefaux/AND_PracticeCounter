package fr.alefaux.practicecounter.feature.practice.detail.panes

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DeleteConfirmationDialog(
    practiceName: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        confirmButton = {
            Button(
                content = {
                    Text(
                        text = "Confirmer"
                    )
                },
                onClick = onConfirm
            )
        },
        dismissButton = {
            TextButton(
                content = {
                    Text(
                        text = "Annuler"
                    )
                },
                onClick = onDismiss
            )
        },
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Êtes vous certain ?"
            )
        },
        text = {
            Text(
                text = "Voulez vous vraiment supprimer l'activité $practiceName ?"
            )
        }
    )
}