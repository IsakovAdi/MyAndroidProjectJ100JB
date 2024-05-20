package com.example.menuoptions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.general_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1->{
                Toast.makeText(this, "Item 1 has been pressed", Toast.LENGTH_SHORT).show()
                openDetailsActivity("Item 1")
            }
            R.id.item2->{
                Toast.makeText(this, "Item 2 has been pressed", Toast.LENGTH_SHORT).show()
                openDetailsActivity("Item 2")
            }
            R.id.item3->{
                Toast.makeText(this, "Item 3 has been pressed", Toast.LENGTH_SHORT).show()
                openDetailsActivity("Item 3")
            }
            R.id.subItem1->{
                Toast.makeText(this, "SubItem 1 has been pressed", Toast.LENGTH_SHORT).show()
                openDetailsActivity("Sub item 1")
            }
        }
        return true
    }

    fun openDetailsActivity(address:String){
        val intent = Intent(this, DetailsActivity::class.java)
//        intent.putExtra("Address", address)
        startActivity(intent)
    }
}