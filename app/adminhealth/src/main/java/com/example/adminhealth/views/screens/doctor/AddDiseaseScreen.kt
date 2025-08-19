package com.example.adminhealth.views.screens.doctor

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.adminhealth.R
import com.example.adminhealth.ui.theme.navyBlue
import com.example.adminhealth.ui.theme.white
import com.example.adminhealth.utils.DISEASE_TABLE
import com.example.adminhealth.viewmodel.AddDiseaseVM
import com.example.adminhealth.views.components.CustomTextField

@Composable
fun AddDiseaseScreen(
    add: () -> Unit,
    btnBack:()->Unit
) {
    val context = LocalContext.current
    val viewModel: AddDiseaseVM = hiltViewModel()
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(navyBlue)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "btn back",
                    tint = white, modifier = Modifier
                        .size(35.dp)
                        .clickable { btnBack() })
                Text(
                    text = "Add Medicine",
                    modifier = Modifier.fillMaxWidth(),
                    color = white,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            CustomTextField(text = viewModel.name.value,
                onTextChange = {
                viewModel.setName(it)
                viewModel.nameError.value = false
                               },
                label = "Name",
                error = viewModel.nameError.value
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(text = viewModel.symptom.value,
                onTextChange = {
                viewModel.setSymptom(it)
                viewModel.symptomError.value = false
                               },
                label = "Symptoms",
                error = viewModel.symptomError.value
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(text = viewModel.prevention.value,
                onTextChange = {
                viewModel.setPrevention(it)
                viewModel.preventionError.value = false
                               },
                label = "Preventions",
                error = viewModel.preventionError.value
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                          if (viewModel.errorNotFound()){
                              val disease = viewModel.createDisease()
                              DISEASE_TABLE.child("${disease.id}").setValue(disease).addOnSuccessListener {
                                  Toast.makeText(context, "Disease Added!", Toast.LENGTH_SHORT).show()
                                  add()
                              }.addOnFailureListener {
                                  Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
                              }
                          }else{
                              viewModel.checkValues()
                          }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = navyBlue,
                    contentColor = white
                ),
                modifier = Modifier.width(150.dp)
            ) {
                Text(text = "ADD")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ShowAddDisease() {
    AddDiseaseScreen(add = {}, btnBack = {})
}