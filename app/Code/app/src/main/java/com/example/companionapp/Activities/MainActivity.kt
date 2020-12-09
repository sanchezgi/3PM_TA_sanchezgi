package com.example.companionapp.Activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.example.companionapp.Adapters.CharacterAdapter
import com.example.companionapp.Classes.Character
import com.example.companionapp.R
import com.example.companionapp.fragments.FragmentA
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_b.*
import java.net.URL

enum class ProviderType{
    BASIC
}

class MainActivity : AppCompatActivity() {

    lateinit var character: Array<Character>
    var isRemembered = false
    var power = Array<String>(6){""}
    var character_class = Array<String>(6){""}
    var race = Array<String>(6){""}
    var level = Array<String>(6){""}
    var image = Array<String>(6){""}
    var login = "login"

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        Thread {
            val response = URL("https://raw.githubusercontent.com/sanchezgi/Jason/master/testjson.json").readText()
            character = Gson().fromJson(response, Array<Character>::class.java)

            runOnUiThread{

                val fragmentA = FragmentA.newInstance(character)


                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_layout,fragmentA)
                    commit();
                }
                StoreInfo()
            }
        }.start()


        //setup
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?: "",provider ?: "")


       /* list?.setOnItemClickListener{parent,view,position,id->
            val intent = Intent(this,CharacterDetails::class.java)
            intent.putExtra("Character",character[position])
            startActivity(intent)
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }


    private fun setup(email:String, provider:String){
        title = "Bault"
    }

    private fun showAlert(message: String){
        val builder  = AlertDialog.Builder(this)
        builder.setTitle("Preferences")
        builder.setMessage(message)
        val dialog = builder.create()
        dialog.show()
    }

    private fun StoreInfo(){
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = prefs.edit()

        for (x in 0 until character.size){
            power[x] = "power" + x
            race[x] = "race" + x
            character_class[x] = "character_class" + x
            level[x] = "level" + x
            image[x] = "image" + x
            editor.putInt(power[x],character[x].power)
            editor.putString(race[x],character[x].race)
            editor.putString(character_class[x],character[x].characterclass)
            editor.putString(level[x],character[x].level)
            editor.putString(image[x],character[x].image)
        }

        editor.putInt(login,1)

        editor.apply()

        val mypref = prefs.getInt(power[0],0)
        val mypref2 = prefs.getString(race[0],"")
        val mypref3 = prefs.getString(character_class[0],"")
        val mypref4 = prefs.getString(level[0],"")
        val mypref5 = prefs.getString(image[0],"")
        //showAlert(mypref5.toString())
    }
}