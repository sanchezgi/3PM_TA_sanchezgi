package com.example.companionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val character1 = Character("Titan",1092, "Exo Male", "Level 30",R.drawable.titan)
        val character2 = Character("Warlock",995, "Human Female", "Level 30",R.drawable.warlock)
        val character3 = Character("Hunter",1345, "Awoken Male", "Level 30",R.drawable.hunter)

        val characterlist = listOf(character1,character2,character3)

        val adapter = CharacterAdapter(this,characterlist)

        list.adapter = adapter

        list.setOnItemClickListener{parent,view,position,id->
            val intent = Intent(this,CharacterDetails::class.java)
            intent.putExtra("Character",characterlist[position])
            startActivity(intent)
        }
    }
}