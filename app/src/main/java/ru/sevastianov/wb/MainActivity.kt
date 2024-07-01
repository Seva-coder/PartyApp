package ru.sevastianov.wb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import ru.sevastianov.wb.ui.elements.BottomNavItem
import ru.sevastianov.wb.ui.elements.BarIcon
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
                var selectedItemIndex by rememberSaveable {
                    mutableIntStateOf(0)
                }
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = PartyAppTheme.colors.background
                ) {

                    Scaffold(
                        bottomBar = {
                            NavigationBar(modifier = Modifier.height(60.dp)) {
                                listNavItems.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        colors = androidx.compose.material3.NavigationBarItemDefaults
                                            .colors(
                                                indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(LocalAbsoluteTonalElevation.current)
                                            ),
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                            navController.navigate(item.route)
                                        },
                                        icon = { BarIcon(
                                            imageVector = item.icon,
                                            text = item.name,
                                            activeNow = selectedItemIndex == index
                                        )}
                                    )
                                }
                            }
                        }
                    ) { paddings ->
                        NavHost(navController = navController,
                            startDestination = MyEventsScr,
                            Modifier.padding(paddings)
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
}

@Serializable
object ShowScr

@Serializable
object EventsScr

@Serializable
object MyEventsScr

@Serializable
object ProfileScr