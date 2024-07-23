package ru.sevastianov.wb.ui.elements

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.sevastianov.wb.R

@Composable
fun ShowAvatar(imageUrl: String?, changeAva: Boolean = false, onClick: () -> Unit) {

    Box(modifier = Modifier
        .size((if (changeAva) 100 else 200).dp)
        .clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = imageUrl ?: R.drawable.no_ava_image,
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .background(Color.Transparent)
                .clip(CircleShape)
        )

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