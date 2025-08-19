package com.example.myhealth.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhealth.R
import com.example.myhealth.ui.theme.black
import com.example.myhealth.ui.theme.navyBlue
import com.example.myhealth.ui.theme.white

@Composable
fun CartLabTestView(
    name: String,
    price: Int,
    deleteTest:()->Unit,
    confirmOrder:()->Unit
) {
    var isButtonVisible by remember { mutableStateOf(true) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        border = BorderStroke(1.dp, black),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = white
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Name",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = name)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Price",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = price.toString())
            }
            Spacer(modifier = Modifier.height (10.dp))
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = "Remove",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Image(painter = painterResource(id = R.drawable.ic_bin), contentDescription = "trash",
                    modifier = Modifier
                        .size(15.dp)
                        .clickable { deleteTest() }
                )
            }
            if (isButtonVisible) {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            confirmOrder()
                            isButtonVisible = false
                        },
                        modifier = Modifier.width(170.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = navyBlue,
                            contentColor = white
                        )
                    ) {
                        Text(text = "Confirm Order")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowCartItemTest() {
    CartLabTestView(name = "Test Name", price = 150, deleteTest = {}){}
}