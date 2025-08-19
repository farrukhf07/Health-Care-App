package com.example.myhealth.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myhealth.model.Medicine

@Composable
fun GridItems(
    items: List<Medicine>,
    columns: Int = 2,
    medDetail:(Medicine)->Unit,
    addMedicine:(Medicine)->Unit
) {
    val rows = items.chunked(columns)
    LazyColumn{
        this.items(rows){ rowItems->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (item in rowItems){
                    MedicineView(
                        name = item.name,
                        price = item.price,
                        imagePath = item.medicine_Image,
                        onMedDetail = {
                            medDetail(item)
                        },
                        onClick = {
                            addMedicine(item)
                        }
                    )
                }
            }
        }
    }
}