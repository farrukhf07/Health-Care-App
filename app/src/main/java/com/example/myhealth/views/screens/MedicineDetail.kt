package com.example.myhealth.views.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myhealth.R
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.utils.MEDICINE_TABLE
import com.example.myhealth.viewModel.MedicineDetailVM
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import okhttp3.MediaType

@Composable
fun MedicineDetail(
    btnBack:()->Unit
) {
    val viewModel: MedicineDetailVM = hiltViewModel()
    LaunchedEffect(Unit){
        viewModel.getImage()
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(primaryBlue)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "btn Back",
                    tint = white, modifier = Modifier
                        .size(35.dp)
                        .clickable { btnBack() }
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(text = "Medicine Details",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = white
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(model = viewModel.geturl, contentDescription = "image",
                modifier = Modifier.size(100.dp)
            )
        }
        Log.d("image", "${viewModel.geturl}")

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Name",
                fontSize = 20.sp)
            Text(text = viewModel.medicine.value.name,
                fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Price",
                fontSize = 20.sp)
            Text(text = viewModel.medicine.value.price.toString(),
                fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Type",
                fontSize = 20.sp)
            Text(text = viewModel.medicine.value.type,
                fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Grams",
                fontSize = 20.sp)
            Text(text = viewModel.medicine.value.grams,
                fontSize = 16.sp
            )
        }
    }
}