package com.example.companionapp

import com.example.companionapp.Classes.Armor
import com.example.companionapp.Classes.Character
import com.example.companionapp.Classes.Weapon
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun character_isCorrect() {

        val primary = Array(1) {Weapon(1920,"URL",1)}
        val special = Array(1) {Weapon(1920,"URL",1)}
        val heavy = Array(1) {Weapon(1920,"URL",1)}
        val helmet = Array(1) {Armor(1920,"URL")}

        var character = Character(1942,"Titan","Exo","level 30","URL",primary,special,heavy,helmet)

        assertEquals(1942, character.power)
        assertEquals("Titan", character.characterclass)
        assertEquals("Exo", character.race)
        assertEquals("level 30", character.level)
        assertEquals("URL", character.image)

        assertEquals(1920, character.primaryweapon?.get(0)?.power)
        assertEquals("URL", character.primaryweapon?.get(0)?.image)
        assertEquals(1, character.primaryweapon?.get(0)?.type)

        assertEquals(1920, character.specialweapon?.get(0)?.power)
        assertEquals("URL", character.specialweapon?.get(0)?.image)
        assertEquals(1, character.specialweapon?.get(0)?.type)

        assertEquals(1920, character.heavyweapon?.get(0)?.power)
        assertEquals("URL", character.heavyweapon?.get(0)?.image)
        assertEquals(1, character.heavyweapon?.get(0)?.type)

        assertEquals(1920, character.helmet?.get(0)?.power)
        assertEquals("URL", character.helmet?.get(0)?.image)
    }
}