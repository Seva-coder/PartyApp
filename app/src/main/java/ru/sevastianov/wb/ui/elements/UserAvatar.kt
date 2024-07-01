package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun UserAvatar(id: Int?,
               online: Boolean,
               drawBorder: Boolean = false,
               xOffset: Dp = 0.dp) {
    val id = id ?: R.drawable.ava_default

    val statusColor = PartyAppTheme.colors.statusColor

    val modifier = if (drawBorder) {
        Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .offset(x = xOffset)
            .clip(RoundedCornerShape(16.dp))
            .border(2.dp, PartyAppTheme.colors.avaBorderColor, shape = RoundedCornerShape(16.dp))
    } else {
        Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .clip(CircleShape)
    }

    Box(modifier = Modifier
        .size(56.dp)
    ) {
        Image(
            painter = painterResource(id),
            contentDescription = "avatar",
            contentScale = ContentScale.Fit,
            modifier = modifier
        )

        if (online) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val canvasWidth = size.width
                val canvasHeight = size.height

                drawCircle(
                    color = Color.White,
                    radius = 8.dp.toPx(),
                    center = Offset(0.85f*canvasWidth, 0.15f*canvasHeight)
                )

                drawCircle(
                    color = statusColor,
                    radius =  6.dp.toPx(),
                    center = Offset(0.85f*canvasWidth, 0.15f*canvasHeight)
                )
            }
        }
    }
}