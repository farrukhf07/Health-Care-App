package com.example.myhealth.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.AdminUser
import com.example.myhealth.utils.ADMIN_TABLE
import com.example.myhealth.utils.DOCTOR
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class FindDoctorVm @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private val _doctor = mutableStateOf<List<AdminUser>>(emptyList())
    val doctor: State<List<AdminUser>> = _doctor

    fun fetchDoctorData(){
        val doctorList = mutableListOf<AdminUser>()
        ADMIN_TABLE.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(doctors in snapshot.children){
                    val doctor = doctors.getValue(AdminUser::class.java)
                    Log.d("Doctor Data", doctor.toString())
                    if((doctor != null) && (doctor.role == DOCTOR)){
                        doctorList.add(doctor)
                    }
                }
                _doctor.value = doctorList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Database", error.message)
            }

        })
    }
}