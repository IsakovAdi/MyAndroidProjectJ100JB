package com.example.onlinemarket.presentation.fragments.register_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinemarket.domain.interactors.cloud.UserInteractors
import com.example.onlinemarket.domain.models.Image
import com.example.onlinemarket.domain.models.User
import com.example.onlinemarket.domain.models.UserResponse
import kotlinx.coroutines.launch

class RegisterFragmentViewModel(
    private val userInteractors: UserInteractors,
) : ViewModel() {

    private val _userResponse: MutableLiveData<UserResponse> = MutableLiveData()
    val userResponse: LiveData<UserResponse> get() = _userResponse

    val showToast: MutableLiveData<Boolean> = MutableLiveData(false)

    fun register(
        userName: String,
        email: String,
        login: String,
        password: String,
        userAvatar: Image? = null,
    ) = viewModelScope.launch {
        kotlin.runCatching {
            userInteractors(
                user = User(
                    userName = userName,
                    login = login,
                    email = email,
                    password = password,
                    userImage = userAvatar
                )
            )
        }.onSuccess {
            if (it != null) _userResponse.value = it
            else showToast.value = true
        }.onFailure {
            showToast.value = true
        }
    }

    fun toastShown() {
        showToast.value = false
    }

}