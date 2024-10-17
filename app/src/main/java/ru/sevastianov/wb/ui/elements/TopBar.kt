package ru.sevastianov.wb.ui.elements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import ru.sevastianov.wb.R
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    showBack: Boolean = true,
    onBackPressed: () -> Unit,
    rButtonType: RightButton = RightButton.NONE,
    navController: NavController
) {

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = PartyAppTheme.colors.background,
            titleContentColor = PartyAppTheme.colors.darkTextColor,
        ),
        title = {
            Text(
                title,
                style = PartyAppTheme.typography.subheading1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = { if (showBack) {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "back"
                    )
                }
            }
        },
        actions = {
            when (rButtonType) {
                RightButton.NONE -> {  }
                RightButton.EDIT -> {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "edit"
                        )
                    }
                }
                RightButton.SHARE -> {
                    IconButton(onClick = {
                        navController.navigate(Screen.Custom) {
                            popUpTo(Screen.Custom) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.share),
                            tint = PartyAppTheme.colors.newMainColor,
                            contentDescription = "add"
                        )
                    }
                }
                RightButton.OK -> {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            tint = PartyAppTheme.colors.initialColor,
                            contentDescription = "checked"
                        )
                    }
                }

            }
        }
    )


}

enum class RightButton {
    NONE, OK, EDIT, SHARE
}