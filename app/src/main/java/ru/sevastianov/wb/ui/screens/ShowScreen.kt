package ru.sevastianov.wb.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.sevastianov.wb.ProfileScr
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.elements.Chip
import ru.sevastianov.wb.ui.elements.EventAvatar
import ru.sevastianov.wb.ui.elements.EventCard
import ru.sevastianov.wb.ui.elements.GroupCard
import ru.sevastianov.wb.ui.elements.HoverBtn
import ru.sevastianov.wb.ui.elements.HoverOutlinedBtn
import ru.sevastianov.wb.ui.elements.HoverTextBtn
import ru.sevastianov.wb.ui.elements.MainBtn
import ru.sevastianov.wb.ui.elements.MainOutlineBtn
import ru.sevastianov.wb.ui.elements.MainTextBtn
import ru.sevastianov.wb.ui.elements.Search
import ru.sevastianov.wb.ui.elements.ShowAvatar
import ru.sevastianov.wb.ui.elements.SomeAvatars
import ru.sevastianov.wb.ui.elements.TypoBlock
import ru.sevastianov.wb.ui.elements.UserAvatar

@Composable
fun ShowScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        val rowModifier = Modifier.fillMaxWidth()

        // Adding Buttons ////////////////////////////
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))
        Row(
            modifier = rowModifier,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            MainBtn(text = "проф", isEnabled = true, onClick = {
                val dest = ProfileScr
                navController.navigate(dest) {
                    popUpTo(dest)
                    launchSingleTop = true
                }
            })
            MainOutlineBtn(text = "out", isEnabled = true)
            MainTextBtn(text = "text", isEnabled = true)
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        Row(
            modifier = rowModifier,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            HoverBtn(text = "main")
            HoverOutlinedBtn(text = "out")
            HoverTextBtn(text = "text")
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        Row(
            modifier = rowModifier,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            MainBtn(text = "main", isEnabled = false, onClick = {  })
            MainOutlineBtn(text = "out", isEnabled = false)
            MainTextBtn(text = "text", isEnabled = false)
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        // Adding Typography ////////////////////////////
        TypoBlock()

        // Adding Avatars ////////////////////////////
        Row {
            UserAvatar(id = R.drawable.dog, online = true)
            EventAvatar(id = R.drawable.ava_main)
        }
        // Adding 2 versions search bar ////////////////////////////

        Spacer(modifier = Modifier.height(10.dp))
        Search(onSearch = {})

        // Adding chip ////////////////////////////
        Row {
            Chip("Python")
            Chip("Junior")
            Chip("Moscow")
        }


        EventCard(
            imageId = R.drawable.logo_test,
            title = "Фестиваль радиоэлектроники",
            dateWithPlace = "01.09.24 - Budva",
            tags = listOf("android", "kotlin"),
            isEnded = false
        )
        EventCard(
            imageId = R.drawable.ava_main,
            title = "Сходка",
            dateWithPlace = "01.01.24 - secret place",
            tags = listOf("sea", "mountains", "kotlin", "iOS", "long long TAG"),
            isEnded = true
        )

        SomeAvatars(
            ids = listOf(
                R.drawable.logo2,
                R.drawable.logo2,
                R.drawable.dog,
                R.drawable.dog,
                R.drawable.logo2,
                R.drawable.dog,
                R.drawable.dog,
                R.drawable.logo2,
                R.drawable.logo2
            )
        )

        UserAvatar(id = R.drawable.dog, online = true)
        UserAvatar(id = R.drawable.logo2, online = true)

        GroupCard(
            imageId = R.drawable.dog,
            groupName = "Имя группы",
            numberPerson = 0
        )
        GroupCard(
            imageId = R.drawable.dog,
            groupName = "Имя группы",
            numberPerson = 1
        )
        GroupCard(
            imageId = R.drawable.dog,
            groupName = "Имя группы",
            numberPerson = 102
        )

        Row {
            ShowAvatar(imageId = null, changeAva = true, onClick = { })
            ShowAvatar(imageId = R.drawable.dog, changeAva = false, onClick = { })

        }
        ShowAvatar(
            imageId = R.drawable.logo_test,
            changeAva = true,
            onClick = { }
        )

    }
}