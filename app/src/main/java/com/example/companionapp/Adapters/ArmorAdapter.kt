package com.example.companionapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.companionapp.Classes.Armor
import com.example.companionapp.R
import com.squareup.picasso.Picasso

class ArmorAdapter(var context: Context, var arrayArmor:List<Armor>) : RecyclerView.Adapter<ArmorAdapter.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list_item_armor,parent,false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return arrayArmor.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var armor:Armor = arrayArmor.get(position)
        Picasso.get().load(armor.image).into(holder.icons)

        holder.powerArmor.text = armor.power.toString()
    }

    class ItemHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.icons_image)
        var powerArmor = itemView.findViewById<TextView>(R.id.powerArmorText)
    }
}