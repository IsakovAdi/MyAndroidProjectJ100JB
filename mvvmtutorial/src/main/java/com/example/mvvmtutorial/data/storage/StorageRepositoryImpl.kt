package com.example.mvvmtutorial.data.storage

import android.content.Context


class StorageRepositoryImpl(context: Context) : StorageRepository {
    val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun save(text: String) {
        sharedPref.edit().putString(SAVED_TEXT_NAME, text).apply()
    }

    override fun getText(): String {
        val savedText = sharedPref.getString(SAVED_TEXT_NAME, "") ?: ""
        return savedText
    }

    companion object {
        private const val SHARED_PREF_NAME = "SHARED_PREF_NAME"
        private const val SAVED_TEXT_NAME = "SAVED_TEXT_NAME"
    }
}