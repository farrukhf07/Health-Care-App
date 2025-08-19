package com.example.myhealth.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.Disease
import com.example.myhealth.model.LabTest
import com.example.myhealth.utils.DISEASE_TABLE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class DiseaseListVM @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private val _disease = mutableStateOf<List<Disease>>(emptyList())
    val disease: State<List<Disease>> = _disease

    fun fetchDiseaseData(){
        val diseaseList = mutableListOf<Disease>()
        DISEASE_TABLE.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(diseases in snapshot.children){
                    val disease = diseases.getValue(Disease::class.java)
                    if(disease != null){
                        diseaseList.add(disease)
                    }
                }
                _disease.value = diseaseList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Database", error.message)
            }

        }
        )
    }
}