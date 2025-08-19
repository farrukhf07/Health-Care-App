package com.example.myhealth.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.LabTest
import com.example.myhealth.model.Laboratory
import com.example.myhealth.utils.TEST_TABLE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import javax.inject.Inject

class LabTestChughtaiVM @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    private val _tests = mutableStateOf<List<LabTest>>(emptyList())
    val testChughtai: State<List<LabTest>> = _tests

    init {
        fetchTestsData()
    }

    fun fetchTestsData(){
        val testList = mutableListOf<LabTest>()
        TEST_TABLE.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (Tests in snapshot.children){
                    val test = Tests.getValue<LabTest>()
                    if ((test != null && test.laboratory==Laboratory.CHUGHTAI.id)){
                        testList.add(test)
                    }
                }
                _tests.value = testList
            }
            override fun onCancelled(error: DatabaseError) {
                Log.d("Database", error.message)
            }

        })
    }
}