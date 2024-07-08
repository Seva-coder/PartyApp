package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun EventAvatar(urlImage: String) {
    AsyncImage(
        model = urlImage,
        contentDescription = "meeting",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(PartyAppTheme.colors.background)
    )
}