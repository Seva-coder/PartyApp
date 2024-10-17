package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun AvatarsList(
    modifier: Modifier = Modifier,
    urls: List<String>,
    maxNumber: Int = 8,
    onClick: () -> Unit = { }
) {
    Row(
        modifier = modifier
            .height(47.dp)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.spacedBy((-20).dp)
    ) {
        urls.take(maxNumber).forEach { imageUrl ->  // фильтруем юзеров с авами на бэкэнде
            AsyncImage(
                model = imageUrl,
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(47.dp)
                    .background(Color.Transparent)
                    .clip(CircleShape)
            )
        }

        if (urls.size > maxNumber) {
            MorePeopleNumber(number = (urls.size - maxNumber))
        }
    }
}