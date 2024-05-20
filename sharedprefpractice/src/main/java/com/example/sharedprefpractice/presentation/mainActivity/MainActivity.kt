package com.example.sharedprefpractice.presentation.mainActivity

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedprefpractice.databinding.ActivityMainBinding
import com.example.sharedprefpractice.databinding.WantSaveDialogBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val itemsAdapter by lazy {
        ItemAdapter()
    }

    private var isChanged = false

    private val viewModel by lazy {
        MainActivityViewModel(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getData()

        viewModel.items.observe(this) { items ->
            itemsAdapter.addItems(items)
        }

        initViews()
        setOnClickListeners()
        initSwipe()
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
                viewModel.removeItem(viewHolder.adapterPosition)
                isChanged = true
            }
        }
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(binding.itemsRv)
    }

    private fun setOnClickListeners() {
        binding.apply {
            insertBtn.setOnClickListener {
                createAndInsertItem()
            }
            saveBtn.setOnClickListener {
                saveData()
            }
        }
    }

    private fun createAndInsertItem() {
        if (binding.line1Et.text.trim().isNotEmpty() && binding.line2Et.text.trim().isNotEmpty()) {
            viewModel.createDate(
                binding.line1Et.text.toString(),
                binding.line2Et.text.toString()
            )
            isChanged = true
        } else {
            makeToast("Поля должны быть заполнены")
        }
    }

    private fun makeToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun initViews() {
        binding.itemsRv.adapter = itemsAdapter
    }

    private fun saveData() {
        viewModel.saveData()
        isChanged = false
        makeToast("Данные сохранены")
    }

    override fun onBackPressed() {
        if (isChanged) {
            showDialog()
        } else {
            super.onBackPressed()
        }
    }

    private fun showDialog() {
        val dialogBinding = WantSaveDialogBinding.inflate(layoutInflater)
        dialogBinding.apply {
            val dialog = AlertDialog.Builder(this@MainActivity)
                .setView(root)
                .setPositiveButton("Сохранить", null)
                .setNegativeButton("Не надо", null)
                .create()

            dialog.setOnShowListener {
                dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
                    saveData()
                    dialog.dismiss()
                    super.onBackPressed()
                }
                dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener {
                    dialog.dismiss()
                    super.onBackPressed()
                }
            }
            dialog.show()
        }
    }
}