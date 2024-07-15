package ru.sevastianov.wb.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.sevastianov.wb.R
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.elements.MainTextBtn
import ru.sevastianov.wb.ui.elements.SmsCodeField
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun SmsInputScreen(phone: String, navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = stringResource(R.string.input_code_label),
            color = PartyAppTheme.colors.darkTextColor,
            style = PartyAppTheme.typography.heading2,
        )
        Text(text = stringResource(R.string.code_sent_to_label),
            color = PartyAppTheme.colors.darkTextColor,
            style = PartyAppTheme.typography.bodyText2)
        Text(text = phone,
            color = PartyAppTheme.colors.darkTextColor,
            style = PartyAppTheme.typography.bodyText2)

        Spacer(modifier = Modifier.height(49.dp))

        SmsCodeField(
            modifier = Modifier
                .width(248.dp),
            maxLength = 4,
            codeInputed = { code ->
                val dest = Screen.CreateUserScreen
                navController.navigate(dest) {
                    popUpTo(dest) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        )

        Spacer(modifier = Modifier.height(69.dp))

        MainTextBtn(
            text = stringResource(R.string.resend_code_label),
            onClick = {  },
            modifier = Modifier.width(244.dp),
        )

    }
}