package com.example.myhealth.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.CartTable
import com.example.myhealth.model.Medicine
import com.example.myhealth.navigation.DestinationArgs
import com.example.myhealth.utils.AUTH
import com.example.myhealth.utils.AppUtil
import com.example.myhealth.utils.MEDICINE_TABLE
import com.example.myhealth.utils.Preference
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson
import java.net.URLDecoder
import javax.inject.Inject
import kotlin.random.Random

class MedicineListVm @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel(){
    private val _medicine = mutableStateOf<List<Medicine>>(emptyList())
    val medicine: State<List<Medicine>> = _medicine

    init {
        fetchMedicineData()
    }

    fun fetchMedicineData(){
        val medicineList = mutableListOf<Medicine>()
        MEDICINE_TABLE.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (medicines in snapshot.children){
                    val medicine = medicines.getValue(Medicine::class.java)
                    if(medicine != null){
                        medicineList.add(medicine)
                    }
                }
                _medicine.value = medicineList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Database", error.message)
            }

        })
    }
}