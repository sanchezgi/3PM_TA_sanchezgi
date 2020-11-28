package com.example.companionapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AlertDialog
import com.example.companionapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val login = prefs.getInt("login",0)
        //showAlert(login.toString())

        setup()


    }

    private fun setup(){


        signUpButton.setOnClickListener{
            if(emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailEditText.text.toString(),
                    passwordEditText.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        showBault(it.result?.user?.email ?:"",
                            ProviderType.BASIC
                        )
                    } else {
                        //showAlert()
                    }
                }
            }
        }

        LoginButton.setOnClickListener{
            if(emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailEditText.text.toString(),
                    passwordEditText.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        showBault(it.result?.user?.email ?:"",
                            ProviderType.BASIC
                        )
                    } else {
                        //showAlert()
                    }
                }
            }
        }
    }

    private fun showAlert(message: String){
        val builder  = AlertDialog.Builder(this)
        builder.setTitle("Preferences")
        builder.setMessage(message)
        val dialog = builder.create()
        dialog.show()
    }

    private fun showBault(email:String,provider: ProviderType){
        val baultIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email",email)
            putExtra("provider",provider.name)
        }
        startActivity(baultIntent)
    }
}