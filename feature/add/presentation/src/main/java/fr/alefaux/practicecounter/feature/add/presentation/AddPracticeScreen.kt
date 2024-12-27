package fr.alefaux.practicecounter.feature.add.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.alefaux.practicecounter.feature.add.panes.AddPracticePane

@Composable
fun AddPracticeScreen(
    modifier: Modifier = Modifier,
    viewModel: AddPracticeViewModel = viewModel(),
    onBackClicked: () -> Unit
) {
    AddPracticePane(
        modifier = modifier,
        objective = viewModel.objective,
        onBackClicked = onBackClicked,
        onCreateClicked = viewModel::onCreateClicked,
        onObjectiveChanged = viewModel::onObjectiveChanged,
        onTitleChanged = viewModel::onTitleChanged,
        title = viewModel.title
    )
}