package com.example.companionapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.companionapp.Classes.Character
import com.example.companionapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character_section.view.*


class CharacterAdapter(val mContext:Context, private val CharacterList: Array<Character>): ArrayAdapter<Character>(mContext,0,CharacterList ) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout = LayoutInflater.from(mContext).inflate(R.layout.character_section,parent,false)


        val character = CharacterList[position]
        layout.powerWeaponText.text = character.race
        layout.CharacterClassText.text = character.characterclass
        layout.PowerText.text = character.power.toString()
        layout.LevelText.text = character.level
        Picasso.get().load(character.image).into(layout.imageView)

        return layout
    }

    public fun sortList(){
        CharacterList.sortByDescending { it.power }
        notifyDataSetChanged()
    }

}