package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardSearchField() {

    val text = remember { mutableStateOf("") }

    ProvideTextStyle(value = TextStyle(fontSize = 20.sp)) {
        SearchBar(
            query = text.value,
            onQueryChange = { text.value = it },
            onSearch = { },
            active = false,
            onActiveChange = { },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "",
                    tint = PartyAppTheme.colors.greyTextColor2
                )
            },

            placeholder = {
                Text(
                    text = "SearchBar",
                    color = PartyAppTheme.colors.darkTextColor,
                )
            },
            shape = RoundedCornerShape(4.dp),
            colors = SearchBarDefaults.colors(
                containerColor = PartyAppTheme.colors.neutralWhite
            ),
            tonalElevation = 50.dp,
            modifier = Modifier
                .background(color = PartyAppTheme.colors.neutralWhite)
                .fillMaxWidth()
        ) {

        }
    }
}