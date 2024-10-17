package ru.sevastianov.wb.ui.newScreens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.sevastianov.wb.ui.models.EventsListState
import ru.sevastianov.wb.ui.newElements.EventsListMainPart
import ru.sevastianov.wb.ui.newViewModels.EventsScreenVM
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
internal fun EventsScreen(vm: EventsScreenVM = koinViewModel(), navController: NavController) {
    Log.d("SSScreen", "EventsScr")

    val defaultState = EventsListState(
        bigEvents = emptyList(),
        nearestEvents = emptyList(),
        allTags = emptyList(),
        searchingActive = false,
        enabledTags = emptySet(),
        mainEventsList = emptyList(),
        interestsExist = false
    )
    val screenState by vm.getScreenState().collectAsStateWithLifecycle(initialValue = defaultState)

    if (screenState != defaultState) {
        EventsListMainPart(
            screenState = screenState,
            searchFilter = vm::filterBySearchBlock,
            setNewTags = vm::updateEnabledTags,
            navController = navController
        )
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                strokeWidth = 5.dp,
                color = PartyAppTheme.colors.newMainColor,
                trackColor = PartyAppTheme.colors.newGreyColor,
            )
        }
    }

}