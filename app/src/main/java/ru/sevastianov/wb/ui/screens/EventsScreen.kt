package ru.sevastianov.wb.ui.screens


import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.elements.EventsList
import ru.sevastianov.wb.ui.elements.Search
import ru.sevastianov.wb.ui.theme.PartyAppTheme
import ru.sevastianov.wb.ui.viewmodels.EventsVM

@Composable
fun EventsScreen(vm: EventsVM = koinViewModel(), navController: NavController) {
    var tabIndex by remember { mutableStateOf(MyEventsTab.ALL_EVENTS) }

    Column {
        Search(onSearch = { })
        TabRow(
            selectedTabIndex = tabIndex.ordinal,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex.ordinal]),
                    color = PartyAppTheme.colors.initialColor
                )
            },
            divider = { }
        ) {
            Tab(selected = tabIndex == MyEventsTab.ALL_EVENTS,
                onClick = { tabIndex = MyEventsTab.ALL_EVENTS },
                selectedContentColor = PartyAppTheme.colors.initialColor,
                unselectedContentColor = PartyAppTheme.colors.greyTextColor3,
                text = { Text(stringResource(R.string.all_events_tab_label).uppercase(), fontSize = 14.sp) }
            )

            Tab(selected = tabIndex == MyEventsTab.ACTIVE_EVENTS,
                onClick = { tabIndex = MyEventsTab.ACTIVE_EVENTS },
                selectedContentColor = PartyAppTheme.colors.initialColor,
                unselectedContentColor = PartyAppTheme.colors.greyTextColor3,
                text = { Text(stringResource(R.string.active_events_tab_label).uppercase(), fontSize = 14.sp) }
            )

        }
        when (tabIndex) {
            MyEventsTab.ALL_EVENTS -> EventsList(eventsListFlow = vm.getAllEvents(), navController = navController)
            MyEventsTab.ACTIVE_EVENTS -> EventsList(eventsListFlow = vm.getActiveEvents(), navController = navController)
        }

    }
}

private enum class MyEventsTab {
    ALL_EVENTS, ACTIVE_EVENTS
}