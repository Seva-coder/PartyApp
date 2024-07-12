package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ru.sevastianov.wb.R
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.testGroups
import ru.sevastianov.wb.ui.screens.EventDetailScreen
import ru.sevastianov.wb.ui.screens.EventsScreen
import ru.sevastianov.wb.ui.screens.GroupDetailScreen
import ru.sevastianov.wb.ui.screens.GroupsScreen
import ru.sevastianov.wb.ui.screens.MyEventsScreen
import ru.sevastianov.wb.ui.screens.ProfileScreen
import ru.sevastianov.wb.ui.screens.ShowScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import ru.sevastianov.wb.ui.screens.ShowCustomViews


@Composable
fun Navigation(
    navController: NavHostController,
    paddings: PaddingValues,
    title: MutableState<String>,
    isRootScr: MutableState<Boolean>,
    rButtonType: MutableState<RightButton>,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.EventsScr,
        Modifier.padding(
            top = paddings.calculateTopPadding(),
            bottom = paddings.calculateBottomPadding()
        )
    ) {
        composable<Screen.MyEventsScr> { entry ->
            title.value = stringResource(R.string.my_events_screen_title)
            isRootScr.value = false
            rButtonType.value = RightButton.PLUS
            EventsScreen(navController = navController)
        }

        composable<Screen.ShowScr> { entry ->
            title.value = stringResource(R.string.show_screen_title)
            isRootScr.value = false
            rButtonType.value = RightButton.NONE
            ShowScreen(navController)
        }

        composable<Screen.EventsScr> { entry ->
            title.value = stringResource(R.string.events_screen_title)
            isRootScr.value = true
            rButtonType.value = RightButton.NONE
            //MyEventsScreen(navController = navController)
            ShowCustomViews()
        }

        composable<Screen.ProfileScr> { entry ->
            title.value = stringResource(R.string.profile_screen_title)
            isRootScr.value = false
            rButtonType.value = RightButton.EDIT
            ProfileScreen()
        }

        composable<Screen.GroupsScr> { entry ->
            title.value = stringResource(R.string.groups_screen_title)
            isRootScr.value = false
            rButtonType.value = RightButton.NONE
            GroupsScreen(groupList = testGroups, navController = navController)
        }

        composable<Screen.GroupDetailScr> { entry ->
            title.value = stringResource(R.string.group_details_screen_title)
            isRootScr.value = false
            rButtonType.value = RightButton.NONE
            val scr: Screen.GroupDetailScr = entry.toRoute()
            GroupDetailScreen(groupId = scr.groupId, navController = navController)
        }

        composable<Screen.EventDetailScr> { entry ->
            title.value = stringResource(R.string.event_details_screen_title)
            isRootScr.value = false
            rButtonType.value = RightButton.NONE
            val scr: Screen.EventDetailScr = entry.toRoute()
            EventDetailScreen(eventId = scr.eventId)
        }

    }
}