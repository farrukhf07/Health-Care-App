package com.example.myhealth.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.LabTest
import com.example.myhealth.navigation.DestinationArgs
import com.google.gson.Gson
import java.net.URLDecoder
import javax.inject.Inject

class LabTestDetailVM @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    val test: LabTest = Gson().fromJson(URLDecoder.decode(savedStateHandle[DestinationArgs.test], "UTF-8"),LabTest::class.java)

    init {
        Log.d("Test Data", "${test}")
    }
}