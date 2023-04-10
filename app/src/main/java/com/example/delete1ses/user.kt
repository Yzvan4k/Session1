package com.example.delete1ses

data class userdata(
    val id: Int,
    val email: String,
    val firstname: String,
    val lastname: String,
    val patronymic: String,
    val avatar:String?,
    val sex: String,
    val dateBirthDay: String
)
data class responstoken(
    val user:userdata,
    val token: String,
    val error:String?
)
