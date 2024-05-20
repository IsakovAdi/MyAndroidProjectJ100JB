package com.example.rvaddandnewitem

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter() : RecyclerView.Adapter<CarAdapter.ViewHolder>() {
    var cars = mutableListOf<Car>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.car_title)
        val price = view.findViewById<TextView>(R.id.car_price)
        fun bind(car: Car) {
            title.text = car.carTitle
            price.text = car.carPrice.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cars_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CarAdapter.ViewHolder, position: Int) {
        holder.bind(cars[position])
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    fun addNewCar(car: Car) {
        cars.add(0, car)
        notifyItemInserted(0)
    }

    fun removeCar(position: Int) {
        cars.removeAt(position)
        notifyItemRemoved(position)
    }


    fun clear() {
        cars.clear()
        notifyDataSetChanged()
    }
}