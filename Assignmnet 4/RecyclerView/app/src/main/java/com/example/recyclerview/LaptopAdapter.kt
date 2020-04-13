package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.laptop_item.view.*

class LaptopAdapter(private val laptops: List<Laptop>) : RecyclerView.Adapter<LaptopAdapter.LaptaopViewHolder>() {

    class LaptaopViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaptaopViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.laptop_item, parent, false)
        return LaptaopViewHolder(view)
    }

    override fun getItemCount(): Int = laptops.size

    override fun onBindViewHolder(holder: LaptaopViewHolder, position: Int) {
        val l: Laptop = laptops[position]

        holder.itemView.logo.setImageResource(l.logo)
        holder.itemView.companyName.text = l.title
        holder.itemView.price.text = l.price
    }


}