package com.example.onlinemarket.presentation.fragments.login_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlinemarket.domain.interactors.storage.UserStorageInteractor
import com.example.onlinemarket.domain.models.User

class LoginFragmentViewModel(
    private val userStorageInteractor: UserStorageInteractor,
) : ViewModel() {
    private val _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User> get() = _user


    fun checkSavedUser() {
        kotlin.runCatching {
            userStorageInteractor.getSavedUser()
        }.onSuccess {
            if (it != null) _user.value = it
        }
    }

    fun login(login: String, password: String) {

    }

}