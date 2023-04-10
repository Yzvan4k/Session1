package com.example.delete1ses

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Response

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val Upname = findViewById<EditText>(R.id.editName)
        val UpSecondname = findViewById<EditText>(R.id.editLastname)
        val Uppatronymic = findViewById<EditText>(R.id.editPatronymic)
        val Upsex = findViewById<EditText>(R.id.editSex)
        val Updateofbirth = findViewById<EditText>(R.id.editdateofBirth)
        val Upmail = findViewById<EditText>(R.id.editMail)
        val Uppass = findViewById<EditText>(R.id.editPass)
        val Uppass2 = findViewById<EditText>(R.id.editPass2)

        button6.setOnClickListener { startActivity(Intent(this,SignIn::class.java)) }


        button5.setOnClickListener {
            val upname = Upname.text.toString()
                if (upname.isEmpty()){
                    error(this,"Error","Empty Name")
                    return@setOnClickListener
            }

            val uplastname = UpSecondname.text.toString()
                if (uplastname.isEmpty()){
                    error(this,"Error","Empty lastName")
                    return@setOnClickListener}
            val uppatronymic = Uppatronymic.text.toString()
                if (uppatronymic.isEmpty()) {
                    error(this, "Error", "Empty patronymic")
                    return@setOnClickListener}
            val upsex = Upsex.text.toString()
            if (upsex.isEmpty()) {
                error(this, "Error", "Empty sex")
                return@setOnClickListener}
            val updateofbirth = Upname.text.toString()
            if (updateofbirth.isEmpty()) {
                error(this, "Error", "Empty dateofBirth")
                return@setOnClickListener}
            val upmail = Upname.text.toString()
            if (upmail.isEmpty()) {
                error(this, "Error", "Empty mail")
                return@setOnClickListener}
            val uppass = Upname.text.toString()
            if (uppass.isEmpty()) {
                error(this, "Error", "Empty password")
                return@setOnClickListener}
            val uppass2 = Upname.text.toString()
            if (uppass2.isEmpty()) {
                error(this, "Error", "Empty password")
                return@setOnClickListener}
            api.reg(RegB(upname,uplastname,uppatronymic,upmail,uppass,updateofbirth,upsex)).enqueue(object :retrofit2.Callback<responstoken>{
                override fun onResponse(call: Call<responstoken>, response: Response<responstoken>) {
                    if (response.body() != null && response.body()?.error != null){
                        startActivity(Intent(this@SignUp,Main::class.java))
                    }else{ error(this@SignUp,"Error", response.body().toString())
                    if (response.body() == null){
                        error(this@SignUp,"Error", response.body().toString())}
                    else if (response.body()!!.error != null){
                        error(this@SignUp,"Error", response.body()!!.error!!)
                    }}
                }

                override fun onFailure(call: Call<responstoken>, t: Throwable) {
                    error(this@SignUp, "Error", t.localizedMessage ?: t.message ?: "Unknown error")
                }
            })



                }}
}