package com.example.companionapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.companionapp.Classes.Weapon
import com.example.companionapp.R
import com.squareup.picasso.Picasso

class ItemAdapter(var context: Context, var arrayWeapons:List<Weapon>) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list_item,parent , false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return arrayWeapons.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var weapon:Weapon = arrayWeapons.get(position)
        Picasso.get().load(weapon.image).into(holder.icons)

        if (weapon.type == 0){
            holder.element.setImageResource(R.drawable.kinetic)
        }else if (weapon.type == 1){
            holder.element.setImageResource(R.drawable.solar)
        }else if (weapon.type == 2){
            holder.element.setImageResource(R.drawable.arc)
        }else if (weapon.type == 3){
            holder.element.setImageResource(R.drawable.voidelement)
        }else{
            holder.element.setImageResource(R.drawable.kinetic)
        }

        holder.powerWeapon.text = weapon.power.toString()
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.icons_image)
        var powerWeapon = itemView.findViewById<TextView>(R.id.powerWeaponText)
        var element = itemView.findViewById<ImageView>(R.id.elementView)

    }
}