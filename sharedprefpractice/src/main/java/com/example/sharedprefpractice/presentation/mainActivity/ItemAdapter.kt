package com.example.sharedprefpractice.presentation.mainActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedprefpractice.R
import com.example.sharedprefpractice.domain.model.Item

class ItemAdapter:RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private val items = mutableListOf<Item>()
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val line1 = view.findViewById<TextView>(R.id.line1)
        val line2 = view.findViewById<TextView>(R.id.line2)
        fun bind(item: Item){
            line1.text = item.line1
            line2.text = item.line2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun addItems(itemsList:List<Item>){
        items.clear()
        items.addAll(itemsList)
        notifyDataSetChanged()
    }
}