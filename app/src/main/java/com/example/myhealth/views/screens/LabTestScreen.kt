package com.example.myhealth.views.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhealth.R
import com.example.myhealth.ui.theme.black
import com.example.myhealth.ui.theme.gray
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white

@Composable
fun LabTestScreen(
    btnBack:()->Unit,
    chugtaiLabClick:()->Unit,
    essaLabClick:()->Unit,
    excelLabClick:()->Unit
) {
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
                    modifier = Modifier.size(30.dp)
                        .clickable { btnBack() }, tint = white
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Lab Test",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = white
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Certified Partner Labs",
            fontSize = 22.sp,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
        ){
            item {
                Card(
                    modifier = Modifier.clickable { chugtaiLabClick() },
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    border = BorderStroke(1.dp, black),
                    shape = RectangleShape
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.Transparent),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card (
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(50.dp)
                        ){
                            Image(painter = painterResource(id = R.drawable.ic_chugtai_lab), contentDescription = "chugtai lab",
                                modifier = Modifier.size(60.dp))
                        }
                        Text(text = "Chughtai Lab",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(text = "1574 tests available")
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Explore Now",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(painter = painterResource(id = R.drawable.ic_next), contentDescription = "next",
                                modifier = Modifier.size(20.dp))
                        }
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Card(
                    modifier = Modifier.clickable { essaLabClick() },
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    border = BorderStroke(1.dp, black),
                    shape = RectangleShape
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.Transparent),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card (
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(50.dp)
                        ){
                            Image(painter = painterResource(id = R.drawable.ic_esa_lab), contentDescription = "essa lab",
                                modifier = Modifier.size(60.dp))
                        }
                        Text(text = "Dr. Essa Lab",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(text = "693 tests available")
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Explore Now",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(painter = painterResource(id = R.drawable.ic_next), contentDescription = "next",
                                modifier = Modifier.size(20.dp))
                        }
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Card(
                    modifier = Modifier.clickable { excelLabClick() },
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    border = BorderStroke(1.dp, black),
                    shape = RectangleShape
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(Color.Transparent),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card (
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(50.dp)
                        ){
                            Image(painter = painterResource(id = R.drawable.ic_excel_lab), contentDescription = "excel lab",
                                modifier = Modifier.size(60.dp))
                        }
                        Text(text = "Excel Lab",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(text = "738 tests available")
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Explore Now",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(painter = painterResource(id = R.drawable.ic_next), contentDescription = "next",
                                modifier = Modifier.size(20.dp))
                        }
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLabTest() {
    LabTestScreen(btnBack = {}, chugtaiLabClick = {}, essaLabClick = {}, excelLabClick = {})
}