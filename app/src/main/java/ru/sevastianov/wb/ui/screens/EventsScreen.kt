package ru.sevastianov.wb.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import ru.sevastianov.wb.ui.elements.MyPrevEventsList
import ru.sevastianov.wb.ui.elements.MyEventsList
import ru.sevastianov.wb.ui.elements.Search
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun MyEventsScreen() {
    var tabIndex by remember { mutableIntStateOf(0) }

    Column() {
        Search(onSearch = { })

        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                    color = PartyAppTheme.colors.initialColor
                )
            },
            divider = { }
        ) {
            Tab(selected = tabIndex == 0,
                onClick = { tabIndex = 0 },
                selectedContentColor = PartyAppTheme.colors.initialColor,
                unselectedContentColor = PartyAppTheme.colors.greyTextColor3,
                text = { Text("Все встречи".uppercase(), fontSize = 14.sp) }
            )

            Tab(selected = tabIndex == 1,
                onClick = { tabIndex = 1 },
                selectedContentColor = PartyAppTheme.colors.initialColor,
                unselectedContentColor = PartyAppTheme.colors.greyTextColor3,
                text = { Text("Активные".uppercase(), fontSize = 14.sp) }
            )
        }

        when (tabIndex) {
            0 -> MyEventsList()
            1 -> MyPrevEventsList()
        }
    }
}