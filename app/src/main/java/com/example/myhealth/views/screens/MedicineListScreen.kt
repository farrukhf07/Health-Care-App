package com.example.myhealth.views.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.R
import com.example.myhealth.model.CartTable
import com.example.myhealth.model.Medicine
import com.example.myhealth.ui.theme.black
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.utils.AppUtil
import com.example.myhealth.utils.CART_TABLE
import com.example.myhealth.viewModel.MedicineListVm
import com.example.myhealth.views.components.GridItems
import com.example.myhealth.views.components.MedicineView
import kotlin.random.Random

@Composable
fun MedicineListScreen(
    btnBack:()->Unit,
    onMedicineDetail:(Medicine)->Unit,
    addMed:()->Unit
) {
    val context = LocalContext.current
    val viewModel: MedicineListVm = hiltViewModel()
    val medicine by viewModel.medicine

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(primaryBlue),
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "back",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { btnBack() }, tint = white)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Medications",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = white
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Use After Consult Doctor or Specialist",
            modifier = Modifier.padding(start = 10.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 15.dp),
            border = BorderStroke(2.dp, Color.LightGray),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = white
            )
        ) {
            GridItems(items = medicine, medDetail = {onMedicineDetail(it)}, addMedicine = {selectedMedicine->
                val id = Random.nextInt(1,3000)
                val medicineCart = CartTable(
                    id = id,
                    user_id = AppUtil.getPatient()?.id ?: 0,
                    medicine_id = selectedMedicine.id,
                    medicine_name = selectedMedicine.name,
                    price = selectedMedicine.price,
                    total_price = selectedMedicine.price * 1,
                    quantity = 1
                )
                CART_TABLE.child("${id}").setValue(medicineCart).addOnSuccessListener {
                    Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show()
                    btnBack()
                }.addOnFailureListener {
                    Toast.makeText(context, "Not currently Available", Toast.LENGTH_SHORT).show()
                }
            })
        }

//        LazyColumn(
//            modifier = Modifier.fillMaxWidth(),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
//        ){
//            this.items(medicine){
//                MedicineView(name = it.name, price = it.price, imagePath = it.medicine_Image,
//                    onMedDetail = {},
//                    addMedicine = {})
//            }
//        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ShowMedicineDashboard() {
//    MedicineListScreen(btnBack = {}, onMedicineDetail = {})
//}