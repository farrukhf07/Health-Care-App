package com.example.myhealth.views.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhealth.R
import com.example.myhealth.ui.theme.PurpleGrey80
import com.example.myhealth.ui.theme.black
import com.example.myhealth.ui.theme.firstAidColor
import com.example.myhealth.ui.theme.lightBlueBackground
import com.example.myhealth.ui.theme.lightGreen1
import com.example.myhealth.ui.theme.lightPink
import com.example.myhealth.ui.theme.primaryBlue
import com.example.myhealth.ui.theme.white
import com.example.myhealth.utils.AppUtil

@Composable
fun DashboardScreen(
    viewAllDisease:()->Unit,
    orderMedicine:()->Unit,
    findDoc:()->Unit,
    labTest:()->Unit,
    aiChat:()->Unit,
    fever:()->Unit,
    dengue:()->Unit,
    heartAttack:()->Unit,
    profile:()->Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(white)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(primaryBlue)
            .padding(bottom = 20.dp)) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "My Health",
                color = white,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 16.sp
            )
            Row(modifier = Modifier.fillMaxWidth()
                .padding(end = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Image(painter = painterResource(id = R.drawable.ic_option), contentDescription = "option",
                    modifier = Modifier.size(30.dp).clickable { profile() }
                )
            }
            Text(
                text = "Hi ${AppUtil.getPatient()?.first_name ?: ""}",
                modifier = Modifier.padding(start = 12.dp),
                color = white,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp),
            colors = CardDefaults.cardColors(
                containerColor = lightGreen1
            ),
            border = BorderStroke(1.dp, Color.Transparent),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { orderMedicine() }
                .padding(horizontal = 20.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(
                        text = "Order Medicines",
                        color = black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text(text = "Delivered to your Doorstep")
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text = "at upto 10% OFF!")
                    Icon(painter = painterResource(id = R.drawable.ic_next), contentDescription = "Next",
                        tint = black)
                }
                Icon(painter = painterResource(id = R.drawable.ic_firstaid), contentDescription = "First aid Kit",
                    tint = firstAidColor
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp),
            colors = CardDefaults.cardColors(
                containerColor = lightPink
            ),
            border = BorderStroke(1.dp, Color.Transparent),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { findDoc() }
                .padding(horizontal = 20.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(
                        text = "Find Doctors",
                        color = black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Text(text = "Book Appointment")
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text = "with Ease")
                    Icon(painter = painterResource(id = R.drawable.ic_next), contentDescription = "Next"
                    , tint = black)
                }
                Image(painter = painterResource(id = R.drawable.ic_doc), contentDescription = "Doctor Image")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp),
            colors = CardDefaults.cardColors(
                containerColor = PurpleGrey80
            ),
            border = BorderStroke(1.dp, Color.Transparent),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { labTest() }
                .padding(horizontal = 20.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(
                        text = "Lab Tests",
                        color = black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Home sampling & in-lab")
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text = "text bookings")
                    Icon(painter = painterResource(id = R.drawable.ic_next), contentDescription = "Next"
                        , tint = black)
                }
                Image(painter = painterResource(id = R.drawable.ic_tubes), contentDescription = "Test Tubes")
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 5.dp),
            colors = CardDefaults.cardColors(
                containerColor = lightBlueBackground
            ),
            border = BorderStroke(1.dp, Color.Transparent),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { aiChat() }
                .padding(horizontal = 20.dp, vertical = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(
                        text = "AI Chatbot",
                        color = black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "24/7 AI Support")
                    Icon(painter = painterResource(id = R.drawable.ic_next), contentDescription = "Next"
                        , tint = black)
                }
                Image(painter = painterResource(id = R.drawable.ic_bot), contentDescription = "AI Bot")
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Common Disease",
            modifier = Modifier.padding(horizontal = 20.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(white),
            horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically) {
            Card(modifier = Modifier
                .background(white)
                .clickable { fever() }
                .padding(horizontal = 5.dp, vertical = 5.dp),
                border = BorderStroke(1.dp, Color.Transparent),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(modifier = Modifier
                    .background(white)
                    .padding(7.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.ic_fever), contentDescription = "dengue image")
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Fever")
                }
            }
            Card(modifier = Modifier
                .background(white)
                .wrapContentWidth()
                .wrapContentHeight()
                .clickable { dengue() }
                .padding(horizontal = 5.dp, vertical = 5.dp),
                border = BorderStroke(1.dp, Color.Transparent),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(modifier = Modifier
                    .background(white)
                    .padding(7.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_dengue), contentDescription = "dengue image")
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Dengue",
                        textAlign = TextAlign.Center
                    )
                }
            }
            Card(modifier = Modifier
                .background(white)
                .wrapContentWidth()
                .wrapContentHeight()
                .clickable { heartAttack() }
                .padding(horizontal = 5.dp, vertical = 5.dp),
                border = BorderStroke(1.dp, Color.Transparent),
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(modifier = Modifier
                    .background(white)
                    .padding(7.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.ic_heartattack), contentDescription = "dengue image")
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "Heart Attack")
                }
            }
            Text(
                text = "View All",
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable {
                    viewAllDisease()
                }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowDashboard() {
    DashboardScreen(viewAllDisease = {}, orderMedicine = {}, findDoc = {}, labTest = {}, aiChat = {}, fever = {}, dengue = {}, heartAttack = {}, profile = {} )
}