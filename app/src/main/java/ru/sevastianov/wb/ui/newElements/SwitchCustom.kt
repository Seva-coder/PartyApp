package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun SwitchCustom(
    checkedInitial: Boolean = false,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit = { }
) {
    var checked by remember { mutableStateOf(checkedInitial) }

    Switch(
        modifier = Modifier
            .width(48.dp)
            .height(24.dp),
        checked = checked,
        enabled = enabled,
        onCheckedChange = {
            checked = it
            onCheckedChange(it)
        },
        thumbContent = {
            // нужен, чтобы размер thumb слева и справа был одинаковый
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = PartyAppTheme.colors.newWhiteColor,
            uncheckedThumbColor = PartyAppTheme.colors.newWhiteColor,
            checkedTrackColor = PartyAppTheme.colors.newMainColor,
            uncheckedTrackColor = PartyAppTheme.colors.uncheckedTrackColor,
            uncheckedBorderColor = Color.Transparent
        )
    )


}