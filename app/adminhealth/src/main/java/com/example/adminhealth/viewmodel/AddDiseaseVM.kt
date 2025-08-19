package com.example.adminhealth.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.adminhealth.model.Disease
import javax.inject.Inject
import kotlin.random.Random

class AddDiseaseVM @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    val name = mutableStateOf("")
    val symptom = mutableStateOf("")
    val prevention = mutableStateOf("")
    var nameError = mutableStateOf(false)
    var symptomError = mutableStateOf(false)
    var preventionError = mutableStateOf(false)

    fun setName(data:String){
        name.value = data
    }
    fun setSymptom(data:String){
        symptom.value = data
    }
    fun setPrevention(data: String){
        prevention.value = data
    }

    fun errorNotFound():Boolean{
        return name.value.isNotEmpty()&&symptom.value.isNotEmpty()&&prevention.value.isNotEmpty()
    }

    fun checkValues(){
        nameError.value = name.value.isEmpty()
        symptomError.value = symptom.value.isEmpty()
        preventionError.value = prevention.value.isEmpty()
    }

    fun createDisease(): Disease{
        val id = Random.nextInt(1,100)
        val disease = Disease(
            id = id,
            name = name.value,
            symptoms = symptom.value,
            prevention = prevention.value
        )
        return disease
    }
}