package ru.sevastianov.wb.ui.screens


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.sevastianov.wb.R
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.elements.EventCard
import ru.sevastianov.wb.ui.theme.PartyAppTheme
import ru.sevastianov.wb.ui.viewmodels.GroupDetailsVM

@Composable
fun GroupDetailScreen(vm: GroupDetailsVM = koinViewModel(), groupId: Long, navController: NavController) {
    vm.setGroupId(groupId)

    val text = vm.getDescription().collectAsStateWithLifecycle().value.description
    val list = vm.getListEvents().collectAsStateWithLifecycle().value

    LazyColumn(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
    ) {
        item {
            Text(
                text = text,
                style = PartyAppTheme.typography.metadata1,
                color = PartyAppTheme.colors.greyTextColor
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.events_of_group_text),
                style = PartyAppTheme.typography.bodyText1,
                color = PartyAppTheme.colors.greyTextColor
            )
        }

        itemsIndexed(list) { index, meeting ->
            Spacer(modifier = Modifier.height(8.dp))
            EventCard(
                imageUrl = meeting.imageUrl,
                title = meeting.title,
                dateWithPlace = meeting.place,
                tags = meeting.tags,
                isEnded = meeting.isEnded,
                eventId = index.toLong()
            ) { eventIdClicked ->
                navController.navigate(Screen.EventDetailScr(eventId = eventIdClicked)) {
                    launchSingleTop = true
                }
            }
            if (index < list.lastIndex) {
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(color = PartyAppTheme.colors.dividerColor)
            }
        }

    }

}