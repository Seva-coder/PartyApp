package ru.sevastianov.wb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import ru.sevastianov.wb.ui.elements.Navigation
import ru.sevastianov.wb.ui.theme.PartyAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //installSplashScreen()
        setContent {
            PartyAppTheme {
                val navController = rememberNavController()

                Navigation(
                    navController = navController
                )
            }
        }
    }
}


sealed class Screen {

    @Serializable
    data object ShowScr : Screen()

    @Serializable
    data object MyEventsScr : Screen()

    @Serializable
    data object EventsScr : Screen()

    @Serializable
    data object ProfileScr : Screen()

    @Serializable
    data object GroupsScr : Screen()

    @Serializable
    data class GroupDetailScr(val groupId: Long) : Screen()

    @Serializable
    data class EventDetailScr(val eventId: Long) : Screen()

    @Serializable
    data object Custom : Screen()

    @Serializable
    data class UsersListScreen(val eventId: Long) : Screen()

    @Serializable
    data object PhoneAuthScreen : Screen()

    @Serializable
    data class SmsAuthScreen(val phone: String) : Screen()

    @Serializable
    data object CreateUserScreen : Screen()

    @Serializable
    data object NewElementsScreen : Screen()

}