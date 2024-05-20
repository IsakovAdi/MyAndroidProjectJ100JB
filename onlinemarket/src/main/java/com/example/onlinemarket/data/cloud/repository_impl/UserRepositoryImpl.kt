package com.example.onlinemarket.data.cloud.repository_impl

import com.example.onlinemarket.data.cloud.dataSource.user_data_source.UserDataSource
import com.example.onlinemarket.data.storage.dataSource.UserStorageDataSource
import com.example.onlinemarket.domain.models.User
import com.example.onlinemarket.domain.models.UserResponse
import com.example.onlinemarket.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val userStorageDataSource: UserStorageDataSource,

    ) : UserRepository {
    override suspend fun register(user: User): UserResponse? {
        val response = userDataSource.register(user)
        return if (response.isSuccessful) {
            login(login = user.login!!, password = user.password!!)
            response.body()
        } else null
    }

    private suspend fun login(login:String, password:String){
        userDataSource.login(login, password)
    }
}