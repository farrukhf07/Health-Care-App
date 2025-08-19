package com.example.adminhealth.views.screens.pharmacy

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
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
import com.example.adminhealth.ui.theme.black
import com.example.adminhealth.ui.theme.gray
import com.example.adminhealth.ui.theme.navyBlue
import com.example.adminhealth.ui.theme.white
import com.example.adminhealth.viewmodel.AddDiseaseVM
import com.example.adminhealth.viewmodel.AddMedicineVM
import com.example.adminhealth.views.components.CustomTextField

@Composable
fun AddMedicineScreen(
    add: () -> Unit,
    btnBack:()->Unit
) {
    val context = LocalContext.current
    val viewModel: AddMedicineVM = hiltViewModel()

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            if (uri != null) {
                Log.d("MY Image URI", "$uri")
                viewModel.imageUri.value = uri
            }

        }
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(navyBlue)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
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
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            CustomTextField(text = viewModel.medName.value,
                onTextChange = {
                viewModel.setMedName(it)
                viewModel.medNameError.value = false
                               },
                label = "Name",
                error = viewModel.medNameError.value
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(text = viewModel.medPrice.value,
                onTextChange = {
                viewModel.setMedPrice(it)
                viewModel.medPriceError.value = false
                               },
                label = "Price",
                error = viewModel.medPriceError.value
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(text = viewModel.medGram.value,
                onTextChange = {
                viewModel.setMedGram(it)
                viewModel.medGramError.value = false
                               },
                label = "mg/ ml",
                error = viewModel.medGramError.value
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(text = viewModel.medType.value,
                onTextChange = {
                viewModel.setMedType(it)
                viewModel.medTypeError.value = false
                               },
                label = "Type",
                error = viewModel.medTypeError.value
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "insert image"
                )
                Button(
                    onClick = {
                        filePickerLauncher.launch("image/*")
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = gray,
                        contentColor = black
                    )
                ) {
                    Text(text = "Select")
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (viewModel.errorNotFound()){
                        viewModel.createMedicine()
                        Toast.makeText(context, "Medicine Added!", Toast.LENGTH_SHORT).show()
                        add()
                    }
                    else{
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
fun ShowAddMedicine() {
    AddMedicineScreen(add = {}, btnBack = {})
}