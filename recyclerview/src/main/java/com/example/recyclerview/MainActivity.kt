package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity(), ProductsAdapter.RecyclerOnClickListener {
    private val productAdapter by lazy {
        ProductsAdapter(this)
    }
    private lateinit var rv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val productsBundle = intent.getBundleExtra("productsIntent")
        val products = productsBundle?.getSerializable("productsBundle")
        val productsList:List<Product> = products as ArrayList<Product>
        rv = findViewById(R.id.product_rv)
        productAdapter.setData(productsList)
        rv.adapter = productAdapter

    }

    override fun onClick(title: String, position: Int, product: Product) {
        Toast.makeText(this, "$title $position", Toast.LENGTH_SHORT).show()
        showBottomSheet(title)
    }

    private fun showBottomSheet(title: String){
        val dialog = BottomSheetDialog(this)
        val layout = layoutInflater.inflate(R.layout.bottom_sheet, null)
        val textView = layout.findViewById<TextView>(R.id.bottom_sheet_title)
        textView.text = title
        dialog.setContentView(layout)
        dialog.show()
    }
}