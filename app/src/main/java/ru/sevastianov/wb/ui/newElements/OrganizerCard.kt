package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun OrganizerCard(
    modifier: Modifier = Modifier,
    title: String,
    name: String,
    text: String,
    imageUrl: String,
    subscribed: Boolean,
    onClick: () -> Unit = { }
) {
    Column(modifier = modifier
        .clickable { onClick() }) {
        Text(
            text = title,
            style = PartyAppTheme.typography.H2,
            color = PartyAppTheme.colors.newDarkColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.End
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = name,
                    style = PartyAppTheme.typography.H4,
                    color = PartyAppTheme.colors.newDarkColor
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = text,
                    style = PartyAppTheme.typography.secondary,
                    color = PartyAppTheme.colors.newDarkColor
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box {
                AsyncImage(
                    modifier = Modifier
                        .size(104.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(PartyAppTheme.colors.background),
                    model = imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center,
                )
                if (subscribed) {
                    Image(
                        modifier = Modifier
                            .offset(4.dp, 57.dp),
                        painter = painterResource(id = R.drawable.subscribed),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}