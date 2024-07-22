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
import ru.sevastianov.wb.Screen
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
                val dest = Screen.ProfileScr
                navController.navigate(dest) {
                    popUpTo(dest)
                    launchSingleTop = true
                }
            })
            MainOutlineBtn(text = "out", isEnabled = true, onClick = {})
            MainTextBtn(text = "text", isEnabled = true, onClick = {})
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        Row(
            modifier = rowModifier,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            HoverBtn(text = "main", onClick = {})
            HoverOutlinedBtn(text = "out", onClick = {})
            HoverTextBtn(text = "text", onClick = {})
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        Row(
            modifier = rowModifier,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            MainBtn(text = "main", isEnabled = false, onClick = {  })
            MainOutlineBtn(text = "out", isEnabled = false, onClick = {})
            MainTextBtn(text = "text", isEnabled = false, onClick = {})
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

        // Adding Typography ////////////////////////////
        TypoBlock()

        // Adding Avatars ////////////////////////////
        Row {
            UserAvatar(urlImage = "https://live.staticflickr.com/65535/53843918114_2f6a4c1b85_o_d.png", online = true)
            EventAvatar(urlImage = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png")
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
            imageUrl = "https://live.staticflickr.com/65535/53844006025_b8715cd329_o_d.png",
            title = "Фестиваль радиоэлектроники",
            dateWithPlace = "01.09.24 - Budva",
            tags = listOf("android", "kotlin"),
            isEnded = false,
            eventId = 1L
        ) {}
        EventCard(
            imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
            title = "Сходка",
            dateWithPlace = "01.01.24 - secret place",
            tags = listOf("sea", "mountains", "kotlin", "iOS", "long long TAG"),
            isEnded = true,
            eventId = 1L
        ) {}

        SomeAvatars(
            urls = listOf(
                "https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg",
                "https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg",
                "https://live.staticflickr.com/65535/53843918114_2f6a4c1b85_o_d.png",
                "https://live.staticflickr.com/65535/53843918114_2f6a4c1b85_o_d.png",
                "https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg",
                "https://live.staticflickr.com/65535/53843918114_2f6a4c1b85_o_d.png",
                "https://live.staticflickr.com/65535/53843918114_2f6a4c1b85_o_d.png",
                "https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg",
                "https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"
            )
        )

        UserAvatar(urlImage = "https://live.staticflickr.com/65535/53843918114_2f6a4c1b85_o_d.png", online = true)
        UserAvatar(urlImage = "https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg", online = true)

        GroupCard(
            urlImage = "https://slm-assets.secondlife.com/assets/3806158/view_large/512x512%20PNG%20Landscape%20Texture%20-%20Sunrise%20Lake.jpg?1309205114",
            groupName = "Имя группы",
            numberPerson = 0,
            groupId = 1L,
            onClick = { id ->  }
        )
        GroupCard(
            urlImage = "https://slm-assets.secondlife.com/assets/3789225/lightbox/512x512%20PNG%20Landscape%20Texture%20-%20Country%20Lane.jpg?1308962600",
            groupName = "Имя группы",
            numberPerson = 1,
            groupId = 1L,
            onClick = { id ->  }
        )
        GroupCard(
            urlImage = "https://pngimg.com/uploads/linux/linux_PNG15.png",
            groupName = "Linux",
            numberPerson = 102,
            groupId = 1L,
            onClick = { id ->  }
        )

        Row {
            ShowAvatar(imageUrl = null, changeAva = true, onClick = { })
            //ShowAvatar(imageUrl = R.drawable.dog, changeAva = false, onClick = { })

        }
/*        ShowAvatar(
            imageUrl = R.drawable.logo_test,
            changeAva = true,
            onClick = { }
        )*/

    }
}