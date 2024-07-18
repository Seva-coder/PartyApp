package ru.sevastianov.wb.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.koin.androidx.compose.koinViewModel
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.elements.Chip
import ru.sevastianov.wb.ui.elements.MainBtn
import ru.sevastianov.wb.ui.elements.MainOutlineBtn
import ru.sevastianov.wb.ui.elements.RightButton
import ru.sevastianov.wb.ui.elements.SomeAvatars
import ru.sevastianov.wb.ui.theme.PartyAppTheme
import ru.sevastianov.wb.ui.viewmodels.EventDetailsVM

@Composable
fun EventDetailScreen(vm: EventDetailsVM = koinViewModel(), eventId: Long, rButtonType: MutableState<RightButton>) {
    val datePlace = "13.09.2024 -Москва, ул.Громова, 4"
    val chips = listOf("Python", "Junior", "Moscow")
    val text = LoremIpsum(100).values.joinToString(separator = " ")

    var showDialog by remember { mutableStateOf(false) }

    var eventClicked by remember { mutableStateOf(false) }

    LazyColumn(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
    ) {
        item {
            Text(
                text = datePlace,
                color = PartyAppTheme.colors.greyTextColor,
                style = PartyAppTheme.typography.bodyText1
            )
        }
        item {
            Row(modifier = Modifier.padding(vertical = 4.dp)) {
                chips.forEach { Chip(text = it) }
            }
        }
        item {
            Image(
                contentScale = ContentScale.None,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 20.dp)
                    .height(175.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .clickable { showDialog = true },
                painter = painterResource(id = R.drawable.map), contentDescription = "map"
            )
        }
        item {
            Text(
                text = text,
                style = PartyAppTheme.typography.metadata1,
                color = PartyAppTheme.colors.greyTextColor
            )
        }
        item {
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
                ),
                modifier = Modifier.padding(top = 30.dp)
            )
        }
        item {
            if (eventClicked) {
                MainOutlineBtn(
                    text = stringResource(R.string.not_go_to_event_btn),
                    onClick = {
                        eventClicked = false
                        rButtonType.value = RightButton.NONE},
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth()
                )
            } else {
                MainBtn(
                    text = stringResource(R.string.go_to_event_btn),
                    onClick = {
                        eventClicked = true
                        rButtonType.value = RightButton.OK},
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .fillMaxWidth()
                )
            }

        }

    }

    if (showDialog) {
        Dialog(
            properties = DialogProperties(usePlatformDefaultWidth = false, dismissOnClickOutside = true),
            onDismissRequest = { showDialog = false }
        ) {
            Image(
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.map), contentDescription = "map"
            )
        }
    }
}