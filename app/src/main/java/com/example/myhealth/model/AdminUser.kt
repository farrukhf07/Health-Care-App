package com.example.myhealth.model

data class AdminUser(
    val id: Int = 0,
    val full_name: String? = null,
    val age: Int? = null,
    val specialist: String? = null,
    val experience: String? = null,
    val degree: String? = null,
    val fee: Int? = null,
    val phoneNo: String = "",
    val timing: String? = null,
    val email: String = "",
    val password: String = "",
    val photo: String? = null,
    //pharmacy not common properties
    val location: String? = null,
    val role: String  = ""
)
//pharmacy sign up
//val user = Doctor(
//    id = 0,
//    full_name = "ksjdnjs",
//    age = null,
//    specialist = null,
//    experience = null,
//    degree = null,
//    fee = null,
//    phoneNo = "sdlkvnklsd",
//    timing = null,
//    email = "lskdfnl",
//    password = "sdklvmvskld",
//    photo = null,
//    location = ";fmvlkafmvkl",
//    role = PHAMC
//
//)

//doc
//pharmacy sign up
//val user = Doctor(
//    id = 0,
//    full_name = "ksjdnjs",
//    age = 03,
//    specialist = "kldfmlk",
//    experience = "lfngl",
//    degree = "sjlafdnl",
//    fee = 938493,
//    phoneNo = "sdlkvnklsd",
//    timing = "fnvlaek",
//    email = "lskdfnl",
//    password = "sdklvmvskld",
//    photo = "ksagnvlad",
//    location = null,
//    role  = Doctor
//
//)
