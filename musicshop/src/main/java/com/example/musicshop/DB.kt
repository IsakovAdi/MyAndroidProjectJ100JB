package com.example.musicshop

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DB(val context:Context) {
    companion object{
        const val SHARED_PREF_NAME = "SHARED_PREF_NAME"
        const val PRODUCTS_TITLE = "PRODUCTS_TITLE"
    }

    fun loadData() : List<Product>{
        val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, AppCompatActivity.MODE_PRIVATE)
        val gson = Gson()
        val jsonObjects = sharedPref.getString(PRODUCTS_TITLE, null)
        val type =object: TypeToken<MutableList<Product>>(){}.type
        val products:MutableList<Product> ?=gson.fromJson(jsonObjects, type)
        if (products == null){
            Toast.makeText(context, "Data is empty", Toast.LENGTH_SHORT).show()
            return emptyList()
        }else{
            return products
        }
    }

    fun saveData(products:List<Product>){
        val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val gson = Gson()
        val saveObjects: String = gson.toJson(products)
        editor.putString(PRODUCTS_TITLE, saveObjects)
        editor.apply()
    }
}