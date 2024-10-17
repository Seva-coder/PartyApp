package ru.sevastianov.wb.ui.newScreens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.sevastianov.wb.ui.elements.RightButton
import ru.sevastianov.wb.ui.elements.TopBar
import ru.sevastianov.wb.ui.models.EventDetailsState
import ru.sevastianov.wb.ui.newElements.EventDetailsMainPart
import ru.sevastianov.wb.ui.newElements.SubscribeBlock
import ru.sevastianov.wb.ui.newElements.SubscribeState
import ru.sevastianov.wb.ui.newViewModels.EventDetailVM
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun EventDetailScreen(
    eventId: Long,
    vm: EventDetailVM = koinViewModel { parametersOf(eventId) },
    navController: NavHostController
) {
    Log.d("SSScreen", "EventDetailScreen")

    val screenStateDefault = EventDetailsState(
        eventName = "",
        dateUnix = 0,
        dateStr = "",
        place = "",
        tagsList = emptyList(),
        eventDescription = "",
        speakerName = "",
        speakerDescription = "",
        speakerImageUrl = "",
        metroName = "",
        avatarsList = emptyList(),
        organizerName = "",
        organizerDescription = "",
        organizerImageUrl = "",
        sameEvents = emptyList(),
        freeSpaces = 0,
        subscription = SubscribeState.IN_PROGRESS,
        eventImageUrl = "",
        lat = 0.0,
        lon = 0.0,
        subscribedToGroup = false
    )

    val screenState by vm.getScreenState()
        .collectAsStateWithLifecycle(initialValue = screenStateDefault)

    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            skipHiddenState = false,
            initialValue = SheetValue.Hidden
        )
    )

    val scope = rememberCoroutineScope()
    var enableBottomPadding by remember {
        mutableStateOf(false)
    }

    val currentUnixTime = System.currentTimeMillis() / 1000
    if (screenState.dateUnix > currentUnixTime) {
        enableBottomPadding = true
        LaunchedEffect(scope) {
            scaffoldState.bottomSheetState.expand()
        }
    }

    var bottomPaddingDp by remember {
        mutableStateOf(0.dp)
    }

    BottomSheetScaffold(
        modifier = Modifier,
        sheetContent = {
            SubscribeBlock(
                freePlaces = screenState.freeSpaces,
                subscribed = screenState.subscription,
                onClick = {
                    when (screenState.subscription) {
                        SubscribeState.SUBSCRIBED -> vm.setEventSubscribe(false)
                        SubscribeState.NOT_SUBSCRIBED -> vm.setEventSubscribe(true)
                        else -> {}
                    }
                },
                measuredHeightDp = { bPadding -> bottomPaddingDp = bPadding }
            )
        },
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                title = screenState.eventName,
                navController = navController,
                showBack = true,
                onBackPressed = { navController.popBackStack() },
                rButtonType = RightButton.SHARE
            )
        },
        sheetDragHandle = null,
        sheetSwipeEnabled = false,
        sheetPeekHeight = 0.dp
    ) {
        if (screenState.dateUnix != 0) {
            EventDetailsMainPart(
                eventId = eventId,
                screenState = screenState,
                enableBottomPadding = enableBottomPadding,
                bottomPaddingDp = bottomPaddingDp,
                navController = navController
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    strokeWidth = 5.dp,
                    color = PartyAppTheme.colors.newMainColor,
                    trackColor = PartyAppTheme.colors.newGreyColor,
                )
            }
        }

    }

}