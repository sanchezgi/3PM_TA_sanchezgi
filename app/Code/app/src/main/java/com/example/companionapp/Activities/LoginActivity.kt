package com.example.companionapp.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AlertDialog
import com.example.companionapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)

        isRemembered = sharedPreferences.getBoolean("CHECKBOX",false)

        if (isRemembered){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        setup()
    }

    private fun setup(){

        signUpButton.setOnClickListener{
            if(emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailEditText.text.toString(),
                    passwordEditText.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){

                        var checked: Boolean = checkBox.isChecked

                        val editor:SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putBoolean("CHECKBOX", checked)
                        editor.apply()

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        showAlert("Error on Sing In")
                    }
                }
            }
        }

        LoginButton.setOnClickListener{
            if(emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailEditText.text.toString(),
                    passwordEditText.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){

                        var checked: Boolean = checkBox.isChecked

                        val editor:SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putBoolean("CHECKBOX", checked)
                        editor.apply()

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        showAlert("Your Email or Password are incorrect. Please try again.")
                    }
                }
            }
        }

        contactButton.setOnClickListener {

            val intent = Intent(this,ContactActivity::class.java)
            startActivity(intent)

        }
    }

    private fun showAlert(message: String){
        val builder  = AlertDialog.Builder(this)
        builder.setTitle("Login Error")
        builder.setMessage(message)
        val dialog = builder.create()
        dialog.show()
    }
}