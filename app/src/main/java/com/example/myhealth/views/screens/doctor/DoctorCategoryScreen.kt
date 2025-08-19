package com.example.myhealth.views.screens.doctor

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhealth.R
import com.example.myhealth.ui.theme.gray
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white

@Composable
fun DoctorCategoryScreen() {
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
                    modifier = Modifier.size(30.dp), tint = white
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Specialities",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = white
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
        Text(text = "Choose a Specialty")
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            item {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Column(modifier = Modifier.weight(1f)) {
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Dentist")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Gynecologist")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Pediatrican")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Neurologist")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Neurosurgeon")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Nutritionist")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Audiologist")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Periodontist")
                            }
                        }
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "General Physician")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "General Surgeon")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Cardiologist")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Family Physician")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Psychologist")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Psychiatrist")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Plastic Surgeon")
                            }
                        }
                        Card(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                            border = BorderStroke(1.dp, Color.Transparent),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .background(gray)) {
                                Text(text = "Sexologist")
                            }
                        }
                    }
                }
            }

        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun ShowDoctorCategory() {
//    DoctorCategoryScreen()
//}