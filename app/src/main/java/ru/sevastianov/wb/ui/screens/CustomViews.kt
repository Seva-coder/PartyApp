package ru.sevastianov.wb.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.elements.PhoneInput
import ru.sevastianov.wb.ui.elements.SmsCodeField

@Composable
fun ShowCustomViews() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        SmsCodeField(
            maxLength = 4,
            codeInputed = { text -> Log.d("READY", text) },
            modifier = Modifier
                .width(248.dp)
                .height(40.dp)
        )
        Spacer(modifier = Modifier.height(100.dp))
        PhoneInput(modifier = Modifier,
            onEnter = { phone -> Log.d("PHONE", phone) }
        )
    }
}