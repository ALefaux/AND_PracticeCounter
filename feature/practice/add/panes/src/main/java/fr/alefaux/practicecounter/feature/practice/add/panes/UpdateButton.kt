package fr.alefaux.practicecounter.feature.practice.add.panes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.alefaux.practicecounter.feature.practice.add.modelui.ScreenState

@Composable
fun UpdateButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ExtendedFloatingActionButton(
        modifier = modifier,
        icon = {
            Icon(
                imageVector = Icons.TwoTone.Check,
                contentDescription = null,
            )
        },
        onClick = onClick,
        text = {
            Text(text = "Modifier")
        }
    )
}