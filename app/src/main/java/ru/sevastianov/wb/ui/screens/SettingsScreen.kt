package ru.sevastianov.wb.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.sevastianov.wb.R
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.elements.UserAvatar
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun SettingsScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
    ) {
        UserCard(
            urlAvatar = "https://live.staticflickr.com/65535/53843835983_d3d52ce50d_o_d.png",
            userName = "Иван Иванов",
            phone = "+7 999 999-99-99",
            navController = navController
        )
        Spacer(modifier = Modifier.height(10.dp))
        SettingElement(
            iconId = R.drawable.meeting_bar_icon,
            onClick = { navController.navigate(Screen.MyEventsScr) },
            text = stringResource(
                R.string.my_events_settings_label
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        SettingElement(
            iconId = R.drawable.sun_icon,
            onClick = {},
            text = stringResource(R.string.theme_settings_label)
        )
        SettingElement(
            iconId = R.drawable.bell_icon,
            onClick = {},
            text = stringResource(R.string.notifications_settings_label)
        )
        SettingElement(
            iconId = R.drawable.shield_icon,
            onClick = {},
            text = stringResource(R.string.safety_settings_label)
        )
        SettingElement(
            iconId = R.drawable.folder_icon,
            onClick = {},
            text = stringResource(R.string.memory_settings_label)
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = PartyAppTheme.colors.dividerColor)
        Spacer(modifier = Modifier.height(8.dp))
        SettingElement(
            iconId = R.drawable.help_icon,
            onClick = {},
            text = stringResource(R.string.help_settings_label)
        )
        SettingElement(
            iconId = R.drawable.mail_icon,
            onClick = {},
            text = stringResource(R.string.friend_settings_label)
        )
    }
}


@Composable
private fun SettingElement(iconId: Int, text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 5.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 20.dp)
                .size(24.dp)
        )
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            style = PartyAppTheme.typography.bodyText1,
            color = PartyAppTheme.colors.darkTextColor
        )
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
        )
    }
}

@Composable
private fun UserCard(
    urlAvatar: String?,
    userName: String,
    phone: String,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 5.dp)
            .clickable { navController.navigate(Screen.ProfileScr) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        UserAvatar(urlImage = urlAvatar, online = false)
        Column(modifier = Modifier
            .weight(1f)
            .padding(start = 20.dp)
        ) {
            Text(text = userName,
                color = PartyAppTheme.colors.darkTextColor,
                style = PartyAppTheme.typography.bodyText1)
            Text(text = phone,
                color = PartyAppTheme.colors.greyTextColor2,
                style = PartyAppTheme.typography.metadata1)
        }
        Icon(
            Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
        )
    }
}
