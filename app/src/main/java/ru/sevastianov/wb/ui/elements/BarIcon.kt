package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun BarIcon(imageVector: ImageVector, text: String, activeNow: Boolean) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (activeNow) {
            Text(text = text)
            Spacer(modifier = Modifier.height(8.dp))
            Canvas(modifier = Modifier) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                drawCircle(
                    color = Color.DarkGray,
                    radius = 2.dp.toPx(),
                    center = Offset(0.5f*canvasWidth, 0.5f*canvasHeight)
                )
            }
        } else {
            Icon(imageVector = imageVector, contentDescription = "icon")
        }

    }

}