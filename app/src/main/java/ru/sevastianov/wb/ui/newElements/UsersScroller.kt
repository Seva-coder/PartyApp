package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.models.UserCardUI


@Composable
internal fun UsersScroller(
    modifier: Modifier = Modifier,
    users: List<UserCardUI>,
    onClick: (Long) -> Unit = { },
) {
    Column(modifier = modifier) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(users.size) { index ->
                val card = users[index]
                PersonCard(
                    imageUrl = card.imageUrl,
                    name = card.name,
                    userId = card.userId,
                    tagString = card.tagText,
                    onClick = onClick
                )
            }
        }
    }
}