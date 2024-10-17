package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun EventCard(
    imageUrl: String,
    name: String,
    date: String,
    place: String,
    tags: List<String>,
    type: CardType,
    id: Long,
    onClick: (Long) -> Unit
) {

    val modifier = when (type) {
        CardType.Thin -> Modifier.width(212.dp)
        CardType.Big -> Modifier.width(320.dp)
        CardType.Full -> Modifier.fillMaxWidth()
    }

    val style = when (type) {
        CardType.Thin -> PartyAppTheme.typography.H3
        CardType.Big -> PartyAppTheme.typography.H1
        CardType.Full -> PartyAppTheme.typography.H2
    }

    val imageHeight = when (type) {
        CardType.Thin -> 147.dp
        else -> 180.dp
    }

    Column(modifier = modifier
        .clickable { onClick(id) }
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "meeting",
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(imageHeight)
                .clip(RoundedCornerShape(16.dp))
                .background(PartyAppTheme.colors.background)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            style = style,
            color = PartyAppTheme.colors.newDarkColor,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$date · $place",
            style = PartyAppTheme.typography.secondary,
            color = PartyAppTheme.colors.newGreyColor
        )
        Spacer(modifier = Modifier.height(2.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            tags.forEach { tagText ->
                Tag(name = tagText)
                Spacer(modifier = Modifier.width(6.dp))
            }
        }

    }
}


enum class CardType {
    Thin,
    Big,
    Full
}