package ru.sevastianov.wb.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.sevastianov.domain.usecases.IGetUserProfile
import ru.sevastianov.wb.ui.extensions.toUI
import ru.sevastianov.wb.ui.models.UserProfileUI

class ProfileVM(private val getUserProfile: IGetUserProfile) : ViewModel() {

    private val profileFlow = MutableStateFlow(UserProfileUI())
    private val immutableProfileFlow: StateFlow<UserProfileUI> = profileFlow
    internal fun getProfile() = immutableProfileFlow

    init {
        updateProfileData()
    }

    private fun updateProfileData() {
        viewModelScope.launch {
            getUserProfile.execute().collect { profile ->
                profileFlow.value = profile.toUI()
            }
        }
    }

}