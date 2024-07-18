package ru.sevastianov.wb.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.elements.ContactData
import ru.sevastianov.wb.ui.elements.MainOutlineBtn
import ru.sevastianov.wb.ui.elements.ShowAvatar
import ru.sevastianov.wb.ui.viewmodels.ProfileVM

@Composable
fun ProfileScreen(vm: ProfileVM = koinViewModel()) {
    Column(
        modifier = Modifier
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        ShowAvatar(imageId = null, changeAva = false, onClick = { })
        ContactData(name = "Иван Иванов", phone = "+7 999 999-99-99")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val modifier = Modifier
                .width(72.dp)
                .height(40.dp)
            MainOutlineBtn(iconId = R.drawable.twitter, modifier = modifier, onClick = {})
            MainOutlineBtn(iconId = R.drawable.insta, modifier = modifier, onClick = {})
            MainOutlineBtn(iconId = R.drawable.linked, modifier = modifier, onClick = {})
            MainOutlineBtn(iconId = R.drawable.facebook, modifier = modifier, onClick = {})
        }

    }

}