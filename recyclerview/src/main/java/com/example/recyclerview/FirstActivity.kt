package com.example.recyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FirstActivity : AppCompatActivity() {
    lateinit var button: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        button = findViewById(R.id.my_btn)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            val products = createProducts() as ArrayList
            bundle.putSerializable("productsBundle", products)
            intent.putExtra("productsIntent", bundle)
            startActivity(intent)
        }
    }

    fun createProducts():List<Product>{
        val products = arrayListOf<Product>()
        products.add(Product(
            title = "Drums",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 1500,
            count = 4)
        )
        products.add(Product(
            title = "Guitar",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 2500,
            count = 6)
        )
        products.add(Product(
            title = "Keyboard",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 3000,
            count = 2)
        )
        products.add(Product(
            title = "Rock",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 2400,
            count = 1)
        )
        products.add(Product(
            title = "Rock",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 2400,
            count = 1)
        )
        products.add(Product(
            title = "Rock",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 2400,
            count = 1)
        )
        products.add(Product(
            title = "Rock",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 2400,
            count = 1)
        )
        products.add(Product(
            title = "Rock",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 2400,
            count = 1)
        )
        products.add(Product(
            title = "Rock",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 2400,
            count = 1)
        )
        products.add(Product(
            title = "Rock",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 2400,
            count = 1)
        )
        products.add(Product(
            title = "Rock",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 2400,
            count = 1)
        )
        products.add(Product(
            title = "Rock",
            desc = "Мощный барабан по выгодной цене. Купи не пожалеешь",
            price = 2400,
            count = 1)
        )
        return products
    }
}