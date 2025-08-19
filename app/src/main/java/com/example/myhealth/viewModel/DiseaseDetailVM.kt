package com.example.myhealth.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myhealth.model.Disease
import com.example.myhealth.model.Medicine
import com.example.myhealth.navigation.DestinationArgs
import com.google.gson.Gson
import java.net.URLDecoder
import javax.inject.Inject

class DiseaseDetailVM @Inject constructor(
    savedStateHandle: SavedStateHandle
):ViewModel(){
    val disease:Disease = Gson().fromJson(URLDecoder.decode(savedStateHandle[DestinationArgs.disease], "UTF-8"),Disease::class.java)

    init {
        Log.d("Your Data", "${disease}")
    }
}