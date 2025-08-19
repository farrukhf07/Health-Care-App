package com.example.myhealth.views.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myhealth.R
import com.example.myhealth.ui.theme.white
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

@Composable
fun MedicineView(
    name: String,
    price: Int,
    imagePath: String,
    onMedDetail:()->Unit,
    onClick:()->Unit
) {
    var imageUrl by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(imagePath){
        if (imagePath.isNotEmpty()){
            val storageRef = FirebaseStorage.getInstance().reference.child(imagePath)
            // fetch download url
            try{
                imageUrl = storageRef.downloadUrl.await().toString()
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
    Card(modifier = Modifier
        .background(white)
        .wrapContentWidth()
        .wrapContentHeight()
        .padding(horizontal = 5.dp, vertical = 5.dp),
        border = BorderStroke(1.dp, Color.Transparent),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(modifier = Modifier
            .background(white)
            .padding(7.dp)
            .clickable { onMedDetail() }) {
            Row {
                AsyncImage(model = imagePath, contentDescription = "medicine image",
                    placeholder = painterResource(id = R.drawable.ic_firstaid),
                    error = painterResource(id = R.drawable.ic_firstaid))

                FloatingActionButton(onClick ={
                            onClick()
                },
                    modifier = Modifier.size(20.dp)
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "add",
                        Modifier.background(white))
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = name)
            Text(text = "Rs ${price}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowMedicineView() {
    MedicineView(name = "Panadol", imagePath = "", price = 80, onMedDetail = {}, onClick = {})
}