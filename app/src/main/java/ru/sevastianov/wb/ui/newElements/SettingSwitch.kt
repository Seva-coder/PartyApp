package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun SettingSwitch(
    modifier: Modifier = Modifier,
    label: String,
    checked: Boolean = false,
    enabled: Boolean = true,
    onChange: (Boolean) -> Unit = { }
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = PartyAppTheme.typography.primary,
            color = PartyAppTheme.colors.newMainColor
        )
        SwitchCustom(checkedInitial = checked, enabled = enabled, onCheckedChange = onChange)
    }
}