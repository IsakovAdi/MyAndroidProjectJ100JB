package com.example.roomdatabase

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val listener:RecyclerClickListener):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private val items = mutableListOf<Item>()
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val line1 = view.findViewById<TextView>(R.id.line1)
        val line2 = view.findViewById<TextView>(R.id.line2)
        fun bind(item:Item){
            line1.text = item.line1
            line2.text = item.line2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }
    }

    override fun getItemCount(): Int = items.size

    fun addItems(itemsList:List<Item>){
        items.clear()
        items.addAll(itemsList)
        notifyDataSetChanged()
    }
    fun remove(position:Int){
        items.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(item:Item){
        items.add( item)
        notifyDataSetChanged()
    }

    fun changeItem(item:Item, position:Int){
        items.set(position, item)
        notifyItemChanged(position)
    }
    fun getAllItems() = items

    interface RecyclerClickListener{
        fun onClick(position:Int)
    }

}