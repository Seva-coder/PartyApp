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
import ru.sevastianov.wb.ui.screens.EventsScreen
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
                        route = MyEventsScr,
                        icon = ImageVector.vectorResource(id = R.drawable.meeting_bar_icon)
                    ),
                    BottomNavItem(
                        name = "Группы",
                        route = ShowScr,
                        icon = ImageVector.vectorResource(id = R.drawable.group_bar_icon)
                    ),
                    BottomNavItem(
                        name = "Ещё",
                        route = EventsScr,
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
                        startDestination = MyEventsScr,
                        Modifier.padding(
                            top = paddings.calculateTopPadding(),
                            bottom = paddings.calculateBottomPadding(),
                            start = 16.dp, end = 16.dp)
                    ) {
                        composable<EventsScr> { entry ->
                            val scr: EventsScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = scr.rightButtonType
                            EventsScreen()
                        }

                        composable<ShowScr> { entry ->
                            val scr: ShowScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = scr.rightButtonType
                            ShowScreen(navController)
                        }

                        composable<MyEventsScr> { entry ->
                            val scr: MyEventsScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = scr.rightButtonType
                            MyEventsScreen()
                        }

                        composable<ProfileScr> { entry ->
                            val scr: ProfileScr = entry.toRoute()
                            title = scr.name
                            isRootScreen = scr.isRoot
                            rTopButton = scr.rightButtonType
                            ProfileScreen()
                        }
                    }
                }



            }
        }
    }
}

interface Screen {
    val name: String
    val isRoot: Boolean
    val rightButtonType: RightButton
}

@Serializable
data object ShowScr : Screen {
    override val name = "Набор элементов"
    override val isRoot = false
    override val rightButtonType = RightButton.NONE
}

@Serializable
data object EventsScr : Screen {
    override val name = "Мои встречи"
    override val isRoot = false
    override val rightButtonType = RightButton.PLUS
}

@Serializable
data object MyEventsScr : Screen {
    override val name = "Встречи"
    override val isRoot = true
    override val rightButtonType = RightButton.NONE
}

@Serializable
data object ProfileScr : Screen {
    override val name = "Профиль"
    override val isRoot = false
    override val rightButtonType = RightButton.EDIT
}