package com.example.roomdatabase

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.databinding.ActivityMainBinding
import com.example.roomdatabase.databinding.ItemDialogBinding
import com.example.roomdatabase.databinding.ItemLayoutBinding

class MainActivity : AppCompatActivity(), ItemAdapter.RecyclerClickListener {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val database by lazy {
        ItemDatabase.getDatabase(this)
    }

    private val adapter by lazy {
        ItemAdapter(this)
    }

    private val items = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRv()
        binding.saveBtn.setOnClickListener {
            saveNewItem()
        }
        initSwipe()
    }

    fun initRv(){
        binding.itemsRv.layoutManager = LinearLayoutManager(this)
        binding.itemsRv.adapter = adapter
        items.clear()
        items.addAll(database.itemDao().getAllItems())
        adapter.addItems(items)
    }

    fun saveNewItem(){
        val item = Item(
            line1 = binding.line1Et.text.toString(),
            line2 = binding.line2Et.text.toString()
        )
        items.add(item)
        adapter.addItem(item)
        database.itemDao().saveObject(item)
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
                val item = items[viewHolder.adapterPosition]
                items.removeAt(viewHolder.adapterPosition)
                adapter.remove(viewHolder.adapterPosition)
                database.itemDao().deleteObject(item)
            }
        }
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(binding.itemsRv)
    }

    private fun showDialog(item:Item, position: Int) {
        val dialogBinding = ItemDialogBinding.inflate(layoutInflater)
        dialogBinding.apply {
            val dialog = AlertDialog.Builder(this@MainActivity)
                .setView(root)
                .setTitle("Изменение")
                .setPositiveButton("Сохранить", null)
                .setNegativeButton("Не надо", null)
                .create()

            line1EditText.setText(item.line1)
            line2EditText.setText(item.line2)
            dialog.setOnShowListener {
                dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
                    val newItem = item
                    newItem.line1 = dialogBinding.line1EditText.text.toString()
                    newItem.line2 = dialogBinding.line2EditText.text.toString()
                    database.itemDao().changeItem(newItem)
                    items.set(position, newItem)
                    adapter.changeItem(newItem, position)
                    dialog.dismiss()
                }
                dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener {
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
    }

    override fun onClick(position: Int) {
        showDialog(items[position], position)
    }
}