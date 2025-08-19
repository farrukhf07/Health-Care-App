package com.example.adminhealth.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

val AUTH = FirebaseAuth.getInstance()
val DATABASE = FirebaseDatabase.getInstance()

val ADMIN_TABLE = DATABASE.getReference("admin_table")
//val PHARMACY_TABLE = DATABASE.getReference("pharmacy_table")
val TEST_TABLE = DATABASE.getReference("test_table")
val DISEASE_TABLE = DATABASE.getReference("disease_table")
val MEDICINE_TABLE = DATABASE.getReference("medicine_table")

// For Image
val STORAGE = FirebaseStorage.getInstance()
val IMAGE_STORAGE = STORAGE.getReference("Images")
val MED_IMAGE = STORAGE.getReference("medicine_images")

// Shared Preferences
const val LOGIN_RESPONSE = "loginResponse"