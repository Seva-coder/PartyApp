package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun PersonCard(
    imageUrl: String,
    name: String,
    userId: Long,
    tagString: String,
    onClick: (Long) -> Unit
) {

    Column(modifier = Modifier
        .width(104.dp)
        .clickable { onClick(userId) }
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "user",
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(CircleShape)
                .background(PartyAppTheme.colors.background)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = name,
            maxLines = 1,
            style = PartyAppTheme.typography.H4,
            color = PartyAppTheme.colors.newDarkColor,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Tag(name = tagString)
    }

}