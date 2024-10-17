package ru.sevastianov.wb.ui.newScreens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.sevastianov.wb.ui.elements.RightButton
import ru.sevastianov.wb.ui.elements.TopBar
import ru.sevastianov.wb.ui.newElements.PersonCard
import ru.sevastianov.wb.ui.newViewModels.UsersListVM


@Composable
internal fun UsersListScreen(
    vm: UsersListVM = koinViewModel(),
    navController: NavController
) {
    Log.d("SSScreen", "UsersListScreen")
    val usersList by vm.getUsersList().collectAsStateWithLifecycle(initialValue = emptyList())

    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            TopBar(
                title = "Пойдут на встречу",
                onBackPressed = { navController.popBackStack() },
                showBack = true,
                rButtonType = RightButton.NONE,
                navController = navController
            )
        }
    ) { paddings ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(paddings)
                .fillMaxSize(),
            columns = GridCells.Adaptive(minSize = 104.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items(usersList.size) { index ->
                val user = usersList[index]
                PersonCard(
                    imageUrl = user.imageUrl,
                    name = user.name,
                    userId = user.userId,
                    tagString = user.tagText
                ) { userId ->
                    // в макете не описано куда переходить в общем случае
                }
            }
        }
    }


}