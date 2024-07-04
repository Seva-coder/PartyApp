package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun ShowAvatar(imageId: Int?, changeAva: Boolean = false, onClick: () -> Unit) {
    val neutralWhite = PartyAppTheme.colors.neutralWhite

    Box(modifier = Modifier
        .size((if (changeAva) 100 else 200).dp)
        .clickable(onClick = onClick)
    ) {
        if (imageId == null) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val canvasWidth = size.width
                val canvasHeight = size.height

                drawCircle(
                    color = neutralWhite,
                    radius = 0.5f * canvasWidth,
                    center = Offset(0.5f*canvasWidth, 0.5f*canvasHeight)
                )
            }

            Image(
                painter = painterResource(R.drawable.no_ava_image),
                contentDescription = "no avatar",
                modifier = Modifier
                    .align(Alignment.Center)
            )
        } else {
            Image(
                painter = painterResource(imageId),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .background(Color.Transparent)
                    .clip(CircleShape)
            )
        }

        if (changeAva) {
            Image(
                painter = painterResource(R.drawable.plus),
                contentDescription = "editing",
                modifier = Modifier
                    .offset(x = 77.dp, 77.dp)
            )
        }

    }
}