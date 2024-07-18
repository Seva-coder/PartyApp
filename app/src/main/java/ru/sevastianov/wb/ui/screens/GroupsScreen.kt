package ru.sevastianov.wb.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.elements.GroupCard
import ru.sevastianov.wb.ui.elements.Search
import ru.sevastianov.wb.ui.theme.PartyAppTheme
import ru.sevastianov.wb.ui.viewmodels.GroupsVM

@Composable
fun GroupsScreen(vm: GroupsVM = koinViewModel(), groupList: List<Group>, navController: NavController) {
    Column {
        Search(onSearch = {  })

        LazyColumn(modifier = Modifier.padding(
            start = 16.dp, end = 16.dp)
        ) {
            itemsIndexed(groupList) { index, group ->
                Spacer(modifier = Modifier.height(8.dp))
                GroupCard(urlImage = group.imgUrl,
                    groupName = group.name,
                    numberPerson = group.numberPerson,
                    groupId = index.toLong()
                ) { groupIdClicked ->
                    navController.navigate(Screen.GroupDetailScr(groupId = groupIdClicked)) {
                        launchSingleTop = true
                    }
                }
                if (index < groupList.lastIndex) {
                    Spacer(modifier = Modifier.height(8.dp))
                    HorizontalDivider(color = PartyAppTheme.colors.dividerColor)
                }
            }
        }
    }
}


data class Group(val name: String, val imgUrl: String, val numberPerson: Int)