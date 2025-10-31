package fr.alefaux.practicecounter.feature.practice.add.modelui

sealed interface ScreenState {
    object Creating: ScreenState
    object MustBeLoaded: ScreenState
    object Updating: ScreenState
}