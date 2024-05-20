package com.example.sharedprefpractice.data

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedprefpractice.domain.model.Item
import com.example.sharedprefpractice.domain.repository.Repository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RepositoryImpl(
    private val context: Context
):Repository {
    override fun saveData(data: List<Item>) {
        val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val gson = Gson()
        val savingItem = gson.toJson(data)
        editor.putString(SAVED_DATA_NAME, savingItem)
        editor.apply()
    }

    override fun getData(): List<Item> {
        val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, AppCompatActivity.MODE_PRIVATE)
        val gson = Gson()
        val jsonObjects = sharedPref.getString(SAVED_DATA_NAME, null)
        val type = object : TypeToken<MutableList<Item>>() {}.type
        val products: MutableList<Item>? = gson.fromJson(jsonObjects, type)
        return products ?: emptyList()
    }

    companion object {
        const val SHARED_PREF_NAME = "shared_pref_name"
        const val SAVED_DATA_NAME = "svaed_data_name"
    }
}