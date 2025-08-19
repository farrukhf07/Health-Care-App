package com.example.adminhealth.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.adminhealth.model.Medicine
import com.example.adminhealth.utils.MEDICINE_TABLE
import com.example.adminhealth.utils.MED_IMAGE
import javax.inject.Inject
import kotlin.random.Random

class AddMedicineVM @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    val medName = mutableStateOf("")
    val medPrice = mutableStateOf("")
    val medGram = mutableStateOf("")
    val medType = mutableStateOf("")
    val imageUri = mutableStateOf<Uri?>(null)

    var medNameError = mutableStateOf(false)
    var medPriceError = mutableStateOf(false)
    var medGramError = mutableStateOf(false)
    var medTypeError = mutableStateOf(false)

    fun setMedName(data:String){
        medName.value = data
    }
    fun setMedPrice(data: String){
        medPrice.value = data
    }
    fun setMedGram(data: String){
        medGram.value = data
    }
    fun setMedType(data: String){
        medType.value = data
    }

    fun errorNotFound():Boolean{
        return medName.value.isNotEmpty()&&medPrice.value.isNotEmpty()
                &&medGram.value.isNotEmpty()&&medType.value.isNotEmpty()
    }
    fun checkValues(){
        medNameError.value = medName.value.isEmpty()
        medPriceError.value = medPrice.value.isEmpty()
        medGramError.value = medGram.value.isEmpty()
        medTypeError.value = medType.value.isEmpty()
    }


    fun createMedicine(){
        val id = Random.nextInt(1,900)
        imageUri.value?.let { uri ->
            MED_IMAGE.child("${id}").putFile(uri).addOnSuccessListener { task->
                task.metadata?.reference?.downloadUrl?.addOnSuccessListener { downloadUrl->
                    val imgUrl = downloadUrl.toString()
                    val medicine = Medicine(
                        id = id,
                        name = medName.value,
                        price = medPrice.value.toInt(),
                        grams = medGram.value,
                        type = medType.value,
                        medicine_Image = imgUrl
                    )
                    MEDICINE_TABLE.child("${id}").setValue(medicine)
                }
            }
        }
    }
}