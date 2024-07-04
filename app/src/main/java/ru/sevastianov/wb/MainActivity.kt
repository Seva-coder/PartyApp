package ru.sevastianov.wb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import ru.sevastianov.wb.ui.elements.BottomNavItem
import ru.sevastianov.wb.ui.elements.NavBar
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

                Scaffold(
                    containerColor = PartyAppTheme.colors.background,
                    bottomBar = { NavBar(listNavItems = listNavItems, navController = navController) },
                ) { paddings ->
                    NavHost(
                        navController = navController,
                        startDestination = MyEventsScr,
                        Modifier.padding(bottom = paddings.calculateBottomPadding(), start = 16.dp, end = 16.dp)
                    ) {
                        composable<EventsScr> {
                            EventsScreen()
                        }

                        composable<ShowScr> {
                            ShowScreen(navController)
                        }

                        composable<MyEventsScr> {
                            MyEventsScreen()
                        }

                        composable<ProfileScr> {
                            ProfileScreen()
                        }
                    }
                }

            }
        }
    }
}

@Serializable
object ShowScr

@Serializable
object EventsScr

@Serializable
object MyEventsScr

@Serializable
object ProfileScr