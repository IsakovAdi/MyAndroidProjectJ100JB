package com.example.rvaddandnewitem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private val adapter by lazy {
        CarAdapter()
    }
    private lateinit var titleEt: EditText
    private lateinit var priceEt: EditText
    private lateinit var addFab: FloatingActionButton
    private lateinit var carsRv: RecyclerView
    private lateinit var saveBtn:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        initViews()

        addFab.setOnClickListener {
            addNewCar()
        }
        saveBtn.setOnClickListener {
            saveData()
        }

        initSwipe()
    }

    private fun initViews() {
        titleEt = findViewById(R.id.title_et)
        priceEt = findViewById(R.id.price_et)
        addFab = findViewById(R.id.add_fab)
        carsRv = findViewById(R.id.cars_rv)
        carsRv.adapter = adapter
        saveBtn = findViewById(R.id.save_btn)
    }

    private fun addNewCar() {
        if (titleEt.text.trim().isNotEmpty() &&
            priceEt.text.trim().isNotEmpty()
        ) {
            val newCar = Car(
                carTitle = titleEt.text.toString(),
                carPrice = priceEt.text.toString().toInt()
            )
            adapter.addNewCar(newCar)
        }
    }

    private fun initSwipe() {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.removeCar(viewHolder.adapterPosition)
                saveData()
            }
        }
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(carsRv)
    }

    private fun loadData() {
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)
        val gson = Gson()
        val jsonObjects = sharedPref.getString(CARS, null)
        val type =object:TypeToken<MutableList<Car>>(){}.type
        val loadedCars:MutableList<Car> ?=gson.fromJson(jsonObjects, type)
        if (loadedCars == null){
            Toast.makeText(this, "Data is empty", Toast.LENGTH_SHORT).show()
        }else{
            adapter.cars = loadedCars
        }
    }

    private fun saveData() {
        val sharedPref = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE)
        val editor = sharedPref.edit()
        val gson = Gson()
        val saveObjects: String = gson.toJson(adapter.cars)
        editor.putString(CARS, saveObjects)
        editor.apply()
    }

    companion object {
        const val SHARED_PREF_NAME = "SHARED_PREF_NAME"
        const val CARS = "My_cars"
    }
}