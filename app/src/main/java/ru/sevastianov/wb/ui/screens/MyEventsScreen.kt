package ru.sevastianov.wb.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.elements.EventsList
import ru.sevastianov.wb.ui.theme.PartyAppTheme
import ru.sevastianov.wb.ui.viewmodels.MyEventsVM

@Composable
fun MyEventsScreen(vm: MyEventsVM = koinViewModel(), navController: NavController) {
    var tabIndex by remember { mutableStateOf(EventsTab.PLANNED_EVENTS) }

    Column {
        TabRow(
            selectedTabIndex = tabIndex.ordinal,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex.ordinal]),
                    color = PartyAppTheme.colors.initialColor
                )
            },
            divider = { },
            modifier = Modifier
                .padding(horizontal = 16.dp)

        ) {
            Tab(selected = tabIndex == EventsTab.PLANNED_EVENTS,
                onClick = { tabIndex = EventsTab.PLANNED_EVENTS },
                selectedContentColor = PartyAppTheme.colors.initialColor,
                unselectedContentColor = PartyAppTheme.colors.greyTextColor3,
                text = { Text(stringResource(R.string.planned_events_tab_label).uppercase(), fontSize = 14.sp) }
            )

            Tab(selected = tabIndex == EventsTab.LAST_EVENTS,
                onClick = { tabIndex = EventsTab.LAST_EVENTS },
                selectedContentColor = PartyAppTheme.colors.initialColor,
                unselectedContentColor = PartyAppTheme.colors.greyTextColor3,
                text = { Text(stringResource(R.string.prev_events_tab_label).uppercase(), fontSize = 14.sp) }
            )
        }

        when (tabIndex) {
            EventsTab.PLANNED_EVENTS -> EventsList(eventsListFlow = vm.getPlannedEvents(), navController = navController)
            EventsTab.LAST_EVENTS -> EventsList(eventsListFlow = vm.getLastEvents(), navController = navController)
        }
    }
}

private enum class EventsTab {
    PLANNED_EVENTS, LAST_EVENTS
}