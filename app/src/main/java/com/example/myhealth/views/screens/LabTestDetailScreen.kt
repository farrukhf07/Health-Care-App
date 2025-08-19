package com.example.myhealth.views.screens

import android.widget.Toast
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myhealth.R
import com.example.myhealth.model.CartLabTable
import com.example.myhealth.model.CartTable
import com.example.myhealth.ui.theme.navyBlue
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.utils.AppUtil
import com.example.myhealth.utils.CART_LAB_TABLE
import com.example.myhealth.utils.CART_TABLE
import com.example.myhealth.viewModel.LabTestDetailVM
import kotlin.random.Random

@Composable
fun LabTestDetailScreen(
    btnBack:()->Unit
) {
    val context = LocalContext.current
    val viewModel:LabTestDetailVM = hiltViewModel()
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(primaryBlue)
                .padding(horizontal = 20.dp, vertical = 15.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly){
                Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "back",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { btnBack() },
                    tint = white)
                Text(
                    text = "Tests Detail",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = white
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
            Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Test Type",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 26.sp
                )
                Text(text = viewModel.test.name,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Price",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 26.sp
                )
                Text(text = viewModel.test.price.toString(),
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Laboratory",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 26.sp
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = viewModel.test.laboratory,
                    fontSize = 20.sp,
                    textAlign = TextAlign.End
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                val id = Random.nextInt(1,1000)
                val testCart = CartLabTable(
                    id = id,
                    user_id = AppUtil.getPatient()?.id ?: 0,
                    test_id = viewModel.test.id,
                    test_name = viewModel.test.name,
                    price = viewModel.test.price,
                )
                CART_LAB_TABLE.child("${id}").setValue(testCart).addOnSuccessListener {
                    Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show()
                    btnBack()
                }.addOnFailureListener {
                    Toast.makeText(context, "Not currently Available", Toast.LENGTH_SHORT).show()
                }
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = navyBlue,
                    contentColor = white
                ),
                shape = RectangleShape
            ) {
                Text(text = "Proceed", fontSize = 20.sp)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ShowLabTestDetail() {
//    LabTestDetailScreen()
//}