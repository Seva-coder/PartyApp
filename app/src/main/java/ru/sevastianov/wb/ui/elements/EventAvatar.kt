package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun EventAvatar(id: Int) {
    Image(
        painter = painterResource(id),
        contentDescription = "meeting",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(56.dp)
            .clip(RoundedCornerShape(26.dp))
            .background(PartyAppTheme.colors.background)
    )
}