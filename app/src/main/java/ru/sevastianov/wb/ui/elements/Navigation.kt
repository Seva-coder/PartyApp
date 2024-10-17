package ru.sevastianov.wb.ui.elements

import android.util.Log
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.newScreens.EventDetailScreen
import ru.sevastianov.wb.ui.newScreens.EventsScreen
import ru.sevastianov.wb.ui.newScreens.UsersListScreen


@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(
        modifier = Modifier
            .fillMaxSize(),
        navController = navController,
        startDestination = Screen.EventsScr,//Screen.EventDetailScr(eventId = 1L),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
    ) {
        composable<Screen.EventsScr> {
            Log.d("NNavigation", "EventsScr")
            EventsScreen(navController = navController)
        }

        composable<Screen.EventDetailScr> { entry ->
            Log.d("NNavigation", "EventDetailScr")
            val scr: Screen.EventDetailScr = entry.toRoute()
            EventDetailScreen(eventId = scr.eventId, navController = navController)
        }

        composable<Screen.UsersListScreen> { entry ->
            Log.d("NNavigation", "UsersListScreen")
            //val scr: Screen.UsersListScreen = entry.toRoute()  // eventId настроен в предыдущем экране
            UsersListScreen(navController = navController)
        }


    }
}