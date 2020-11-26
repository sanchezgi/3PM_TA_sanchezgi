package com.example.companionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_character_details.*

class CharacterDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        val character = intent.getSerializableExtra("Character") as Character

        CharacterClassText.text = character.characterclass
        powerText.text = character.race
        Picasso.get().load(character.image).into(Emblem)
    }
}