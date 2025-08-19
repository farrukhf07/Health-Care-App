package com.example.myhealth.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

val AUTH = FirebaseAuth.getInstance()
val DATABASE = FirebaseDatabase.getInstance()

// Tables
val ADMIN_TABLE = DATABASE.getReference("admin_table")
val TEST_TABLE = DATABASE.getReference("test_table")
val DISEASE_TABLE = DATABASE.getReference("disease_table")
val MEDICINE_TABLE = DATABASE.getReference("medicine_table")
val PATIENT_TABLE = DATABASE.getReference("patient_table")
val CART_TABLE = DATABASE.getReference("cart_table")
val CART_LAB_TABLE = DATABASE.getReference("cart_lab_table")
val PLACE_ORDER = DATABASE.getReference("place_order")

// For Image
val STORAGE = FirebaseStorage.getInstance()
val IMAGE_STORAGE = STORAGE.getReference("Images")
val MED_IMAGE = STORAGE.getReference("medicine_images")

// Shared Preferences
const val LOGIN_RESPONSE = "loginResponse"
// Shared Preference
//const val FIRST_NAME = "first_name"
//const val LAST_NAME = "last_name"
//const val AGE = "age"
//const val GENDER = "gender"
//const val PHONE_NO = "phone_no"
//const val EMAIL = "email"
//const val PASSWORD = "password"
