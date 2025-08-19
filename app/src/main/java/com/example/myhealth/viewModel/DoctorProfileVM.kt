package com.example.myhealth.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.AdminUser
import com.example.myhealth.navigation.DestinationArgs
import com.example.myhealth.utils.ADMIN_TABLE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson
import java.net.URLDecoder
import javax.inject.Inject

class DoctorProfileVM @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val doctor: MutableState<AdminUser> = mutableStateOf(
        Gson().fromJson(
            URLDecoder.decode(
                savedStateHandle[DestinationArgs.doctor],
                "UTF-8"
            ), AdminUser::class.java
        )
    )

    init {
//        Log.d("doc data", "${doctor}")
        fetchCustomer(doctor.value.id)
    }
    var geturl = mutableStateOf("")
//    fun fetchDocImage() {
//        ADMIN_TABLE.orderByChild("id").equalTo("${doctor.value.id}").addValueEventListener(object :
//            ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                geturl = snapshot.child("photo").getValue(String::class.java)
//            }
//            override fun onCancelled(error: DatabaseError) {
//                Log.d("image", "image not found")
//            }
//
//        })





//        ADMIN_TABLE.orderByChild("id").equalTo("${doctor.value.id}")
//            .addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    geturl = snapshot.child("photo").getValue(String::class.java)
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//              }
//
//            })
//    }

    fun fetchCustomer( id : Int ){
        ADMIN_TABLE.orderByChild("id").equalTo(id.toDouble()).addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (snapshot in dataSnapshot.children) {


                        val value = snapshot.getValue(AdminUser::class.java)
                        geturl.value = value?.photo ?: ""
                        Log.d("FirebaseData", "Data: $value")
                    }
                } else {
                    Log.d("FirebaseData", "No matching data found")
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                throw databaseError.toException() // Handle database error
            }
            })
        }


}