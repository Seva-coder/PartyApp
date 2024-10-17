package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun SubscribeBlock(
    freePlaces: Int = 0,
    subscribed: SubscribeState = SubscribeState.IN_PROGRESS,
    onClick: () -> Unit = { },
    measuredHeightDp: (Dp) -> Unit
) {
    val localDensity = LocalDensity.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .onSizeChanged { newSize ->
                with(localDensity) {
                    measuredHeightDp(newSize.height.toDp())
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (subscribed) {
            SubscribeState.SUBSCRIBED -> {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.you_go_label),
                    style = PartyAppTheme.typography.primary,
                    color = PartyAppTheme.colors.greenColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                ButtonCustom(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.cant_go_button_label),
                    state = ButtonState.Secondary,
                    onClick = onClick
                )
            }

            SubscribeState.NOT_SUBSCRIBED -> {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.free_places_label, freePlaces),
                    style = PartyAppTheme.typography.secondary,
                    color = PartyAppTheme.colors.newMainColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                ButtonCustom(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.join_to_event_button_label),
                    state = ButtonState.Primary,
                    onClick = onClick
                )
            }

            SubscribeState.IN_PROGRESS -> {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(R.string.free_places_label, freePlaces),
                    style = PartyAppTheme.typography.secondary,
                    color = PartyAppTheme.colors.newMainColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                ButtonCustom(
                    modifier = Modifier.fillMaxWidth(),
                    state = ButtonState.Loading,
                    onClick = onClick
                )
            }
        }
    }
}


enum class SubscribeState {
    NOT_SUBSCRIBED,
    IN_PROGRESS,
    SUBSCRIBED
}