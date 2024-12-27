package fr.alefaux.practicecounter.feature.add.presentation

import androidx.lifecycle.ViewModel

class AddPracticeViewModel: ViewModel() {
    var objective: String = ""
        private set

    var title: String = ""
        private set

    fun onCreateClicked() {
        // TODO
    }

    fun onObjectiveChanged(newObjective: String) {
        objective = newObjective
    }

    fun onTitleChanged(newTitle: String) {
        title = newTitle
    }
}