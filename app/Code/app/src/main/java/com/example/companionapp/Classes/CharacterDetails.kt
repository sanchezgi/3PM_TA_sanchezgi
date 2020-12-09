package com.example.companionapp.Classes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.companionapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_character_details.*

class CharacterDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)

        val character = intent.getSerializableExtra("Character") as Character

        CharacterClassText.text = character.characterclass
        powerWeaponText.text = character.race
        Picasso.get().load(character.image).into(Emblem)
    }
}