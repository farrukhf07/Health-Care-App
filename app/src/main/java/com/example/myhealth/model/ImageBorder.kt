package com.example.myhealth.model

import android.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ImageBorder(
    val width: Dp = 3.dp,
    val color: Color,
    val shape: Shape = RectangleShape
)
