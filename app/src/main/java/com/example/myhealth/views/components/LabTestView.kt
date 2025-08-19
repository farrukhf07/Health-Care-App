package com.example.myhealth.views.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhealth.ui.theme.newpurple

@Composable
fun LabTestView(
    name: String,
    price: String,
    laboratory: String,
    onClick:()->Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = newpurple
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Name", fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp)
                Text(text = name, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "price", fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp)
                Text(text = price, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Laboratory", fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp)
                Text(text = laboratory, fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLabTestView() {
    LabTestView(name = "test name", price = "4500", laboratory = "laboratory name here", onClick = {})
}