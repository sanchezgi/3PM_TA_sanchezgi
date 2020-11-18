package com.example.companionapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.character_section.view.*

class CharacterAdapter(private val mContext:Context, private val CharacterList: List<Character>): ArrayAdapter<Character>(mContext,0,CharacterList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout = LayoutInflater.from(mContext).inflate(R.layout.character_section,parent,false)

        val character = CharacterList[position]
        layout.CharacterClassText.text = character.charcaterclass
        layout.RaceText.text = character.race
        layout.PowerText.text = character.power.toString()
        layout.LevelText.text = character.level
        layout.imageView.setImageResource(character.image)

        return layout
    }

}