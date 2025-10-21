package fr.alefaux.practicecounter.core.model

sealed class Result<out T> {
    data class Success<out T>(
        val value: T
    ): Result<T>()

    sealed class Error: Result<Nothing>() {
        data object NotFound: Error()
        data object Unknown: Error()
    }
}
