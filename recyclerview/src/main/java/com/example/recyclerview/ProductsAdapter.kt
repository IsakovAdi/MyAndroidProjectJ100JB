package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(
    private val listener:RecyclerOnClickListener
    ) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    private val products = mutableListOf<Product>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productTitle = view.findViewById<TextView>(R.id.product_title)
        val productDesc = view.findViewById<TextView>(R.id.product_desc)
        val productPrice = view.findViewById<TextView>(R.id.product_price)
        val productCount = view.findViewById<TextView>(R.id.product_count)
        val totalPrice = view.findViewById<TextView>(R.id.product_total_price)
        fun bind(product: Product) {
            productTitle.text = product.title
            productDesc.text = product.desc
            productPrice.text = product.price.toString()
            productCount.text = product.count.toString()
            totalPrice.text = (product.price * product.count).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        holder.bind(products[position])
        holder.itemView.setOnClickListener {
            listener.onClick(products[position].title, position, products[position])
        }
    }

    override fun getItemCount(): Int = products.size

    fun setData(newProducts:List<Product>){
        products.clear()
        products.addAll(newProducts)
        notifyDataSetChanged()
    }

    interface RecyclerOnClickListener{
        fun onClick(title:String, position:Int, product: Product)
    }
}