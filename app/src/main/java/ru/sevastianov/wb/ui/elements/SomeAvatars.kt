package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sevastianov.wb.ui.theme.PartyAppTheme
import ru.sevastianov.wb.ui.theme.sfProFamily

@Composable
fun SomeAvatars(ids: List<Int>) {
    val step = 35
    val maxAvatars = 5

    Box {
        val avaToDisplay = ids.take(maxAvatars).reversed()
        val maxOffset = (avaToDisplay.size - 1) * step
        for (i in avaToDisplay.indices) {
            val id = avaToDisplay[i]
            UserAvatar(id = id,
                online = false,
                drawBorder = true,
                xOffset = (maxOffset - i * step).dp
            )
        }
        if (ids.size > maxAvatars) {
            val plusText = ids.size - maxAvatars
            Text(text = "+$plusText",
                fontSize = 14.sp,
                color = PartyAppTheme.colors.darkTextColor,
                fontFamily = sfProFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(x = (maxOffset + 50).dp)
            )
        }
    }
}
