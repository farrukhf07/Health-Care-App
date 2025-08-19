package com.example.myhealth.viewModel

import android.util.Log
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.Medicine
import com.example.myhealth.navigation.DestinationArgs
import com.example.myhealth.utils.MEDICINE_TABLE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson
import java.net.URLDecoder
import javax.inject.Inject

class MedicineDetailVM @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel(){
    val medicine: MutableState<Medicine> = mutableStateOf(Gson().fromJson(URLDecoder.decode(savedStateHandle[DestinationArgs.medidicne],"UTF-8"),Medicine::class.java))
    init {
        Log.d("Your Data", "${medicine.value}")
    }


    var geturl : String ?= null
    fun getImage(){
        MEDICINE_TABLE.child("${medicine.value.id}").addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                geturl = snapshot.child("medicine_Image").getValue(String::class.java)
            }
            override fun onCancelled(error: DatabaseError) {
                Log.d("image", "image not found")
            }

        })
    }

}