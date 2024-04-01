package com.assignments.presentation.util

import androidx.annotation.StringRes

sealed class UIEvent {
    data class ShowSnackbar(
        @StringRes val messageId: Int
    ): UIEvent()
}