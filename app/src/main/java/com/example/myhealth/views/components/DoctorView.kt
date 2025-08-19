package com.example.myhealth.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhealth.R
import com.example.myhealth.ui.theme.navyBlue
import com.example.myhealth.ui.theme.white
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

@Composable
fun DoctorView(
    name: String,
    profession: String,
    experience: String,
    waitTime: String,
    imagePath: String,
    viewProfile: () -> Unit,
    bookAppointment: () -> Unit,
    isButtonsVisible: Boolean = true
) {
    var imageUrl by remember { mutableStateOf<String?>(null) }
    LaunchedEffect(imagePath) {
        if (imagePath.isNotEmpty()) {
            val storageRef = FirebaseStorage.getInstance().reference.child(imagePath)
            // fetch download URL
            try {
                imageUrl = storageRef.downloadUrl.await().toString()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 5.dp),
        border = BorderStroke(1.dp, Color.Transparent),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .background(white)
                .fillMaxWidth()
                .padding(7.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Card(
                    border = BorderStroke(1.dp, Color.Transparent),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    MyImageViewLoader(
                        modifier = Modifier.size(80.dp),
                        imageUrl = imagePath,
                        placeholder = R.drawable.ic_profile,
                        error = R.drawable.ic_user,
                        isRounded = true,
                        width = 80.dp
                    )

//                    AsyncImage(model = imagePath, contentDescription = "doctor image",
//                        placeholder = painterResource(id = R.drawable.ic_profile),
//                        error = painterResource(id = R.drawable.ic_user)
//                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = profession,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = experience,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = "of Experience")
                }
                Column {
                    Text(
                        text = waitTime,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = "Checkup Time")
                }
                Column {
                    Text(
                        text = "5.0",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "5 reviews",
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            if (isButtonsVisible) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = { viewProfile() },
                        modifier = Modifier.weight(0.5f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = white,
                            contentColor = navyBlue
                        ),
                        shape = RectangleShape,
                        border = BorderStroke(2.dp, navyBlue)
                    ) {
                        Text(text = "View Profile")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(
                        onClick = { bookAppointment() },
                        modifier = Modifier.weight(0.5f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = navyBlue,
                            contentColor = white
                        ),
                        shape = RectangleShape,
                        border = BorderStroke(2.dp, Color.Transparent)
                    ) {
                        Text(text = "Book Appointment")
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowDoctorView() {
    DoctorView(
        name = "Dr. Zakir Naik",
        profession = "Nuro Surgeon",
        experience = "15 years",
        waitTime = "15-20 min",
        viewProfile = { },
        bookAppointment = {},
        isButtonsVisible = true,
        imagePath = ""
    )
}