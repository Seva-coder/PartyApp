package ru.sevastianov.wb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import ru.sevastianov.wb.ui.elements.BottomNavItem
import ru.sevastianov.wb.ui.elements.NavBar
import ru.sevastianov.wb.ui.elements.Navigation
import ru.sevastianov.wb.ui.elements.RightButton
import ru.sevastianov.wb.ui.elements.TopBar
import ru.sevastianov.wb.ui.theme.PartyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            PartyAppTheme {
                val listNavItems = listOf(
                    BottomNavItem(
                        name = getString(R.string.events_tab_text),
                        route = Screen.EventsScr,
                        icon = ImageVector.vectorResource(id = R.drawable.meeting_bar_icon)
                    ),
                    BottomNavItem(
                        name = getString(R.string.groups_tab_text),
                        route = Screen.GroupsScr,
                        icon = ImageVector.vectorResource(id = R.drawable.group_bar_icon)
                    ),
                    BottomNavItem(
                        name = getString(R.string.other_tab_text),
                        route = Screen.MyEventsScr,
                        icon = ImageVector.vectorResource(id = R.drawable.other_bar_icon)
                    )
                )

                val navController = rememberNavController()

                val title = remember { mutableStateOf("") }
                val isRootScreen = remember { mutableStateOf(true) }
                val rTopButton = remember { mutableStateOf(RightButton.NONE) }

                Scaffold(
                    containerColor = PartyAppTheme.colors.background,
                    topBar = {
                        TopBar(title = title.value,
                            showBack = !isRootScreen.value,
                            onBackPressed = { navController.popBackStack() },
                            rButtonType = rTopButton.value)
                    },
                    bottomBar = { NavBar(listNavItems = listNavItems, navController = navController) },
                ) { paddings ->
                    Navigation(
                        navController = navController,
                        paddings = paddings,
                        title = title,
                        isRootScr = isRootScreen,
                        rButtonType = rTopButton)
                }
            }
        }
    }
}

sealed interface Screen {

    @Serializable
    data object ShowScr : Screen

    @Serializable
    data object MyEventsScr : Screen

    @Serializable
    data object EventsScr : Screen

    @Serializable
    data object ProfileScr : Screen

    @Serializable
    data object GroupsScr : Screen

    @Serializable
    data class GroupDetailScr(val groupId: Long) : Screen

    @Serializable
    data class EventDetailScr(val eventId: Long) : Screen

}