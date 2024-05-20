package com.example.musicshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    private val cartAdapter by lazy {
        CartAdapter()
    }
    private val db by lazy {
        DB(this)
    }
    private lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MY_LOG", "OnCreate_CartActivity")
        setContentView(R.layout.activity_cart)
        rv = findViewById(R.id.cart_rv)
        rv.adapter = cartAdapter
    }

    override fun onResume() {
        super.onResume()
        initSwipe()
        cartAdapter.setData(db.loadData())
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
                cartAdapter.removeProduct(viewHolder.adapterPosition)
                db.saveData(cartAdapter.getData())
            }
        }
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(rv)
    }
}