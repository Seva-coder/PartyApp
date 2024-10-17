package ru.sevastianov.wb.ui.newElements


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
fun CommunityCard(
    imageUrl: String,
    name: String,
    joinState: JoinState = JoinState.NotJoined,
    communityId: Long,
    onOpen: (Long) -> Unit = { },
    onJoin: (Long) -> Unit = { }
) {
    Column(modifier = Modifier
        .clickable { onOpen(communityId) }
        .width(104.dp)) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "meeting",
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(104.dp)
                .clip(RoundedCornerShape(16.dp))
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

        // if без {} - здесь всего одна строка!
        val btnState = when (joinState) {
            JoinState.NotJoined -> ButtonState.Plus
            JoinState.Loading -> ButtonState.Loading
            JoinState.Joined -> ButtonState.Subscribed
        }

        ButtonCustom(
            modifier = Modifier
                .height(37.dp)
                .fillMaxWidth(),
            state = btnState,
            onClick = {
                onJoin(communityId)
            }
        )
    }
}


enum class JoinState {
    NotJoined,
    Loading,
    Joined
}