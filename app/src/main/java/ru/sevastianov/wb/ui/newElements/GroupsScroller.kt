package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.models.GroupCardUI


@Composable
internal fun GroupsScroller(
    modifier: Modifier = Modifier,
    groups: List<GroupCardUI>,
    cardClick: (Long) -> Unit = { },
    cardJoin: (Long) -> Unit = { }
) {
    Column(modifier = modifier) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(groups.size) { index ->
                val card = groups[index]
                CommunityCard(
                    imageUrl = card.imageUrl,
                    name = card.name,
                    communityId = card.id,
                    joinState = card.state,
                    onOpen = cardClick,
                    onJoin = cardJoin
                )
            }
        }
    }
}