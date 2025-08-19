package com.example.myhealth.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.LabTest
import com.example.myhealth.model.Laboratory
import com.example.myhealth.utils.TEST_TABLE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class LabTestEssaVm @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel(){
    private val _tests = mutableStateOf<List<LabTest>>(emptyList())
    val testEssa: State<List<LabTest>> = _tests

    init {
        fetchTestData()
    }

    fun fetchTestData(){
        val testList = mutableListOf<LabTest>()
        TEST_TABLE.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(tests in snapshot.children){
                    val test = tests.getValue(LabTest::class.java)
                    if (test != null && test.laboratory==Laboratory.ESSA.id){
                        testList.add(test)
                    }
                }
                _tests.value = testList
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("database", error.message)
            }

        })
    }
}