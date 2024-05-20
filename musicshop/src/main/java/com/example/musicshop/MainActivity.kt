package com.example.musicshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var centerImage: ImageView
    lateinit var spinner: Spinner
    lateinit var productPriceTv: TextView
    lateinit var totalPrice: TextView
    lateinit var minusButton: Button
    lateinit var plusButton: Button
    lateinit var quantity: TextView
    lateinit var userName: EditText
    lateinit var addToCartBtn: Button

    private val products = mutableListOf<Product>()
    private var productsTitles = listOf("Drums", "Guitar", "Keyboard", "Rock")

    private var checkedProductTitle = productsTitles[0]

    private val spinnerAdapter by lazy {
        ArrayAdapter(this, android.R.layout.simple_spinner_item, productsTitles)
    }
    private var productQuantity: Int = 0
    private var productPrice: Int = 2000

    private val db by lazy {
        DB(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MY_LOG", "OnCreate_MainActivity")
        setContentView(R.layout.activity_main)
        initViews()
        setOnClickers()
    }

    private fun setOnClickers() {
        plusButton.setOnClickListener {
            productQuantity++
            counting()
        }
        minusButton.setOnClickListener {
            if (productQuantity > 0) {
                productQuantity--
                counting()
            }
        }
        addToCartBtn.setOnClickListener {
            if (userName.text.isNotEmpty()) {
                createAndAddToListProduct()
            }
        }
    }

    private fun counting() {
        quantity.text = productQuantity.toString()
        totalPrice.text = (productPrice * productQuantity).toString()
        productPriceTv.text = productPrice.toString()
    }

    private fun initViews() {
        addToCartBtn = findViewById(R.id.button)
        userName = findViewById(R.id.editTextTextPersonName)
        centerImage = findViewById(R.id.centerImage)
        spinner = findViewById(R.id.spinner)
        productPriceTv = findViewById(R.id.productPrice)
        totalPrice = findViewById(R.id.total_price_tv)
        minusButton = findViewById(R.id.minus_btn)
        plusButton = findViewById(R.id.plus_btn)
        quantity = findViewById(R.id.order_count_tv)
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        checkedProductTitle = productsTitles[position]
        when (position) {
            0 -> {
                productPrice = 2000
                productQuantity = 0
                centerImage.setImageResource(R.drawable.drums)
            }
            1 -> {
                productPrice = 1500
                productQuantity = 0
                centerImage.setImageResource(R.drawable.guitar)
            }
            2 -> {
                productPrice = 1700
                productQuantity = 0
                centerImage.setImageResource(R.drawable.keyboard)
            }
            3 -> {
                productPrice = 2100
                productQuantity = 0
                centerImage.setImageResource(R.drawable.rock)
            }
        }
        counting()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.cart_item -> {
                startCartActivity()
            }
        }
        return true
    }

    private fun startCartActivity() {
        db.saveData(products)
        val intent = Intent(this, CartActivity::class.java)
        startActivity(intent)
    }

    private fun createAndAddToListProduct() {
        if (productQuantity > 0) {
            var isFound = false
            for (i in products.indices) {
                if (products[i].productTitle.equals(checkedProductTitle)) {
                    products[i].count += productQuantity
                    products[i].totalPrice = products[i].price*products[i].count
                    isFound = true
                    break
                }
            }
            if (!isFound) {
                products.add(
                    Product(
                        userName = userName.text.toString(),
                        productTitle = checkedProductTitle,
                        price = productPrice,
                        count = productQuantity,
                    )
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        products.clear()
        products.addAll(db.loadData())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        db.saveData(products)
    }
}