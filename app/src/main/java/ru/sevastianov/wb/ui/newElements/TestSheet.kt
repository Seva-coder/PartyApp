package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestSheet() {
    @Composable
    fun PersistentBottomSheet(
        isAttending: Boolean = true,
        isLoading: Boolean = false,
        onClick: () -> Unit = {},
        numberOfPlaces: String = "33",
    ) {
        val sheetState = rememberBottomSheetScaffoldState()

        BottomSheetScaffold(
            sheetDragHandle = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Red),
                    contentAlignment = Alignment.TopCenter
                ) {
                    when (isAttending) {
                        true -> {
                            Text(
                                text = "23456",
                                //style = WildBerriesTheme.typography.bodyText1,
                                color = Color.Green,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                        else -> {
                            Text(
                                text = "4567890",
                                //style = WildBerriesTheme.typography.bodyText1,
                                color = Color.Blue,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            },
            scaffoldState = sheetState,
            sheetContent = {
                when (isAttending) {
                    true -> {
                        Text("button")
                    }

                    else -> {
                        Text("Button2")
                    }
                }
            },
            sheetPeekHeight = 300.dp,
            sheetSwipeEnabled = false,
        ) {}
    }
}