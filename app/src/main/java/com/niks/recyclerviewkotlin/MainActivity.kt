package com.niks.recyclerviewkotlin

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    //static list
    val fruitList = listOf<Fruit>(
        Fruit("Mango", "Nikhil"),
        Fruit("Orange", "Niks"),
        Fruit("Banana", "Alex"),
        Fruit("Grapes", "John"),
        Fruit("Pineapple", "Michael"),
        Fruit("Apple", "Rohit")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)

        recyclerView.setBackgroundColor(Color.YELLOW)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = RecyclerViewAdapter(fruitList) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }


    }

    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(
            this@MainActivity,
            "Selected Fruit is : ${fruit.name},\nSelected Supplier is : ${fruit.supplier}",
            Toast.LENGTH_SHORT
        ).show()
    }
}