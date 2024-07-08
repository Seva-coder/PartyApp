package ru.sevastianov.wb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import ru.sevastianov.wb.ui.elements.BottomNavItem
import ru.sevastianov.wb.ui.elements.NavBar
import ru.sevastianov.wb.ui.elements.RightButton
import ru.sevastianov.wb.ui.elements.TopBar
import ru.sevastianov.wb.ui.screens.GroupDetailScreen
import ru.sevastianov.wb.ui.screens.EventDetailScreen
import ru.sevastianov.wb.ui.screens.EventsScreen
import ru.sevastianov.wb.ui.screens.GroupsScreen
import ru.sevastianov.wb.ui.screens.MyEventsScreen
import ru.sevastianov.wb.ui.screens.ProfileScreen
import ru.sevastianov.wb.ui.screens.ShowScreen
import ru.sevastianov.wb.ui.theme.PartyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PartyAppTheme {
                val listNavItems = listOf(
                    BottomNavItem(
                        name = "Встречи",
                        route = Screen.MyEventsScr,
                        icon = ImageVector.vectorResource(id = R.drawable.meeting_bar_icon)
                    ),
                    BottomNavItem(
                        name = "Сообщества",
                        route = Screen.GroupsScr,
                        icon = ImageVector.vectorResource(id = R.drawable.group_bar_icon)
                    ),
                    BottomNavItem(
                        name = "Ещё",
                        route = Screen.EventsScr,
                        icon = ImageVector.vectorResource(id = R.drawable.other_bar_icon)
                    )
                )

                val navController = rememberNavController()

                var title by remember { mutableStateOf("") }
                var isRootScreen by remember { mutableStateOf(true) }
                var rTopButton by remember { mutableStateOf(RightButton.NONE) }

                Scaffold(
                    containerColor = PartyAppTheme.colors.background,
                    topBar = {
                        TopBar(title = title,
                            showBack = !isRootScreen,
                            onBackPressed = { navController.popBackStack() },
                            rButtonType = rTopButton)
                    },
                    bottomBar = { NavBar(listNavItems = listNavItems, navController = navController) },
                ) { paddings ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MyEventsScr,
                        Modifier.padding(
                            top = paddings.calculateTopPadding(),
                            bottom = paddings.calculateBottomPadding(),
                            start = 16.dp, end = 16.dp)
                    ) {
                        composable<Screen.EventsScr> { entry ->
                            val scr: Screen.EventsScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = scr.rightButtonType
                            EventsScreen(navController = navController)
                        }

                        composable<Screen.ShowScr> { entry ->
                            val scr: Screen.ShowScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = scr.rightButtonType
                            ShowScreen(navController)
                        }

                        composable<Screen.MyEventsScr> { entry ->
                            val scr: Screen.MyEventsScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = scr.rightButtonType
                            MyEventsScreen(navController = navController)
                        }

                        composable<Screen.ProfileScr> { entry ->
                            val scr: Screen.ProfileScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = scr.rightButtonType
                            ProfileScreen()
                        }

                        composable<Screen.GroupsScr> { entry ->
                            val scr: Screen.GroupsScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = scr.rightButtonType
                            GroupsScreen(groupList = testGroups, navController = navController)
                        }

                        composable<Screen.GroupDetailScr> { entry ->
                            val scr: Screen.GroupDetailScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = RightButton.NONE
                            GroupDetailScreen(groupId = scr.groupId, navController = navController)
                        }

                        composable<Screen.EventDetailScr> { entry ->
                            val scr: Screen.EventDetailScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = RightButton.NONE
                            EventDetailScreen(eventId = scr.eventId)
                        }

                    }
                }



            }
        }
    }
}

sealed interface Screen {

    @Serializable
    data object ShowScr : Screen {
        val name = "Набор элементов"
        val isRoot = false
        val rightButtonType = RightButton.NONE
    }

    @Serializable
    data object EventsScr : Screen {
        val name = "Мои встречи"
        val isRoot = false
        val rightButtonType = RightButton.PLUS
    }

    @Serializable
    data object MyEventsScr : Screen {
        val name = "Встречи"
        val isRoot = true
        val rightButtonType = RightButton.NONE
    }

    @Serializable
    data object ProfileScr : Screen {
        val name = "Профиль"
        val isRoot = false
        val rightButtonType = RightButton.EDIT
    }

    @Serializable
    data object GroupsScr : Screen {
        val name = "Сообщества"
        val isRoot = false
        val rightButtonType = RightButton.NONE
    }

    @Serializable
    data class GroupDetailScr(val groupId: Long) : Screen {
        val name = "Детали"
        val isRoot = false
        //val rightButtonType = RightButton.NONE  // не работает cast to NavType...
    }

    @Serializable
    data class EventDetailScr(val eventId: Long) : Screen {
        val name = "Developer meeting"
        val isRoot = false
        //val rightButtonType = RightButton.NONE  // не работает cast to NavType...
    }

}