package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.height
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun NavBar(listNavItems:  List<BottomNavItem>, navController: NavHostController) {

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = PartyAppTheme.colors.background,
        modifier = Modifier
            .height(64.dp)
            .graphicsLayer { shadowElevation = 100f }
    ) {
        listNavItems.forEachIndexed { index, item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults
                    .colors(
                        indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                            LocalAbsoluteTonalElevation.current
                        )
                    ),
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.route)
                },
                icon = {
                    BarIcon(
                        imageVector = item.icon,
                        text = item.name,
                        activeNow = selectedItemIndex == index
                    )
                }
            )
        }
    }

}