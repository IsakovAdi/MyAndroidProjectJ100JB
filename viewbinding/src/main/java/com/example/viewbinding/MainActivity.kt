package com.example.viewbinding

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.viewbinding.databinding.ActivityMainBinding
import com.example.viewbinding.databinding.DialogScreenBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button2.setOnClickListener {
            openDialog()
        }
    }

    private fun openDialog() {
        val dialogBinding = DialogScreenBinding.inflate(layoutInflater)
        val imageUrl = "https://images.prom.ua/1065621053_w640_h640_vafelnaya-kartinka-lyubov.jpg"
        Picasso.get().load(imageUrl).into(dialogBinding.imageView)

        dialogBinding.apply {
            val dialog = AlertDialog.Builder(this@MainActivity)
                .setTitle("My Dialog")
                .setView(root)
                .setNeutralButton("middle", null)
                .setPositiveButton("yes", null)
                .setNegativeButton("no", null)
                .create()


            dialog.setOnShowListener {
                dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
                    Toast.makeText(this@MainActivity, "Positive", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener {
                    Toast.makeText(this@MainActivity, "negative", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                dialog.getButton(DialogInterface.BUTTON_NEUTRAL).setOnClickListener {
                    Toast.makeText(this@MainActivity, "natural", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
            dialog.show()
        }


    }
}