package ru.sevastianov.wb.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.sevastianov.wb.R
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.elements.MainBtn
import ru.sevastianov.wb.ui.elements.PhoneInput
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun PhoneInputScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        var btnEnabled by rememberSaveable { mutableStateOf(false) }
        var phoneNumber by rememberSaveable { mutableStateOf("") }

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = stringResource(R.string.input_phone_label),
            color = PartyAppTheme.colors.darkTextColor,
            style = PartyAppTheme.typography.heading2)
        Text(text = stringResource(R.string.code_will_be_sent_label),
            color = PartyAppTheme.colors.darkTextColor,
            style = PartyAppTheme.typography.bodyText2)

        PhoneInput(
            modifier = Modifier
                .padding(vertical = 70.dp)
                .fillMaxWidth(),
            requiredLength = 10,
            currentNumber = { phone -> phoneNumber = phone },
            numberIsReady = { readiness -> btnEnabled = readiness }
        )

        MainBtn(
            text = stringResource(R.string.continue_btn),
            isEnabled = btnEnabled,
            onClick = {
                val dest = Screen.SmsAuthScreen(phone = phoneNumber)
                navController.navigate(dest) {
                    popUpTo(dest) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}