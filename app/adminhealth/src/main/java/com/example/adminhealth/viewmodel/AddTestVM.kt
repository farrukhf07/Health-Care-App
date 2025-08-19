package com.example.adminhealth.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.adminhealth.model.LabTest
import com.example.adminhealth.model.Laboratory
import javax.inject.Inject
import kotlin.random.Random

class AddTestVM @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    val name = mutableStateOf("")
    val price = mutableStateOf("")
    val selectedOption = mutableStateOf(Laboratory.CHUGHTAI.id)
    val options = listOf(Laboratory.CHUGHTAI.id, Laboratory.ESSA.id, Laboratory.EXCEL.id)
    var nameError = mutableStateOf(false)
    var priceError = mutableStateOf(false)

    fun setName(data:String){
        name.value = data
    }
    fun setPrice(data: String){
        price.value = data
    }

    fun errorNotFound():Boolean{
        return name.value.isNotEmpty()&&price.value.isNotEmpty()
    }
    fun checkValues(){
        nameError.value = name.value.isEmpty()
        priceError.value = price.value.isEmpty()
    }

    fun createTest():LabTest{
        val id = Random.nextInt(1,100)
        val labTest = LabTest(
            id = id,
            name = name.value,
            price = price.value.toInt(),
            laboratory = selectedOption.value
        )
        return labTest
    }
}