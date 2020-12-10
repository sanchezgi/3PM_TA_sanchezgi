package com.example.companionapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.companionapp.R
import kotlinx.android.synthetic.main.activity_contact.*
import javax.security.auth.Subject

class ContactActivity : AppCompatActivity() {

    private lateinit var EditTextTo:EditText
    private lateinit var EditTextSubject:EditText
    private lateinit var EditTextMessage:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        EditTextTo = findViewById(R.id.editTextTo)
        EditTextSubject = findViewById(R.id.editTextSubject)
        EditTextMessage = findViewById(R.id.editTextMessage)


        sendButton.setOnClickListener {
            sendMail()
        }
    }

    private fun sendMail(){
        var recipientList:String = EditTextTo.text.toString()
        var recipients:List<String> = recipientList.split(",")

        var subject:String = EditTextSubject.text.toString()
        var message:String = EditTextMessage.text.toString()

        var intent = Intent(Intent.ACTION_SEND)

        intent.setType("message/rfc822")

        intent.putExtra(Intent.EXTRA_EMAIL,recipientList)
        intent.putExtra(Intent.EXTRA_CC,recipientList)
        intent.putExtra(Intent.EXTRA_SUBJECT,subject)
        intent.putExtra(Intent.EXTRA_TEXT,message)

        startActivity(Intent.createChooser(intent,"Choose an email client"))
    }

}