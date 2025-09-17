package com.example.myhealth.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myhealth.ui.theme.primaryBlue

@Composable
fun MessageHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(primaryBlue)
    ) {
        Text(text = "AI Assistant",
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp)
        )
    }
}