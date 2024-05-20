package com.example.musicshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    private val products = mutableListOf<Product>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.cart_product_image)
        val title = view.findViewById<TextView>(R.id.cart_product_title)
        val price = view.findViewById<TextView>(R.id.cart_product_price)
        val count = view.findViewById<TextView>(R.id.cart_product_count)
        val totalPrice = view.findViewById<TextView>(R.id.cart_product_total_price)

        fun bind(product: Product) {
            when (product.productTitle) {
                "Rock" -> {
                    image.setImageResource(R.drawable.rock)
                }
                "Drums" -> {
                    image.setImageResource(R.drawable.drums)
                }
                "Keyboard" -> {
                    image.setImageResource(R.drawable.keyboard)
                }
                "Guitar" -> {
                    image.setImageResource(R.drawable.guitar)
                }
            }
            title.text = product.productTitle
            price.text = product.price.toString()
            count.text = product.count.toString()
            totalPrice.text = product.totalPrice.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cart_product_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CartAdapter.ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun setData(newProducts: List<Product>) {
        products.clear()
        products.addAll(newProducts)
        notifyDataSetChanged()
    }

    fun removeProduct(postition:Int){
        products.removeAt(postition)
        notifyDataSetChanged()
    }

    fun getData():List<Product> = products
}