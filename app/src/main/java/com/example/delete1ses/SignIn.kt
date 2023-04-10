package com.example.delete1ses

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

fun error(context:Context,title:String,message: String){
    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setNegativeButton("Ok",null)
        .show()
}
class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val editMail = findViewById<EditText>(R.id.editMail)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button3.setOnClickListener { startActivity(Intent(this,SignUp::class.java)) }

        button2.setOnClickListener {
            val InMail = editMail.text.toString()
            if (InMail.isEmpty()) {
                error(this, "Error", "Empty Mail")
                return@setOnClickListener
            }else{ if (!Patterns.EMAIL_ADDRESS.matcher(InMail).matches()){
                error(this, "Error", "Wrong Mail")
                return@setOnClickListener }
            }
            val InPass = editPassword.text.toString()
        if (InPass.isEmpty()){
            error(this,"Error","Empty passeord")
            return@setOnClickListener }
        api.login(LogB(InMail,InPass)).enqueue(object : retrofit2.Callback<responstoken>{
            override fun onResponse(call: Call<responstoken>, response: Response<responstoken>) {
                if (response.isSuccessful && response.body() != null){
                    token = response.body()!!.token.toString()
                    startActivity(Intent(this@SignIn,Main::class.java))
                    error(this@SignIn,"Token",response.body()!!.token) }
                else error(this@SignIn,"Error","Unknown Error")
            }

            override fun onFailure(call: Call<responstoken>, t: Throwable) {
                error(this@SignIn,t.message!!,t.localizedMessage?:t.message?:"unknown Error ")
            }
        })
        }}
}