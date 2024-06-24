package com.niks.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val fruitList: List<Fruit>,
    private val clickListener: (Fruit) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {

    //val fruitList = listOf<String>("Mango", "Orange", "Banana", "Grapes", "Pineapple", "Apple")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        //return 5
        return fruitList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.myTextView.text = "Hello RecyclerView $position"
        val fruit = fruitList[position]
        //holder.myTextView.text = "FruitName:  ${fruit.name}"
        //holder.myTextViewSuplier.text = "SupplierName:  ${fruit.supplier}"
        holder.bind(fruit, clickListener)
    }

}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        val myTextViewSuplier = view.findViewById<TextView>(R.id.tvSupplier)
        myTextView.text = "FruitName:  ${fruit.name}"
        myTextViewSuplier.text = "SupplierName:  ${fruit.supplier}"

        view.setOnClickListener {
            //Toast.makeText(view.context, "Selected Fruit is : ${fruit.name}", Toast.LENGTH_SHORT).show()
            clickListener(fruit)
        }
    }

}