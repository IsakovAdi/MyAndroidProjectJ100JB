package com.example.onlinemarket.data.storage.dataSource

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinemarket.domain.models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserStorageDataSourceImpl(val context: Context) : UserStorageDataSource {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, AppCompatActivity.MODE_PRIVATE)
    private val gson = Gson()
    override fun saveUser(user: User) {
        val editor = sharedPreferences.edit()
        val savingObject = gson.toJson(user)
        editor.putString(SAVING_OBJECT_NAME, savingObject)
        editor.apply()
    }

    override fun getSavedUser(): User? {
        val jsonObject = sharedPreferences.getString(SAVING_OBJECT_NAME, null)
        val type = object : TypeToken<User>() {}.type
        return gson.fromJson(jsonObject, type)
    }

    override fun removeUser() {

    }

    companion object {
        private const val SHARED_PREF_NAME = "USER_SHARED_PREF_NAME"
        private const val SAVING_OBJECT_NAME = "USER_SAVING_OBJECT_NAME"
    }
}