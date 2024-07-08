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
fun SomeAvatars(urls: List<String?>, modifier: Modifier = Modifier) {
    val step = 35
    val maxAvatars = 5

    Box(modifier = modifier) {
        val avaToDisplay = urls.take(maxAvatars).reversed()
        val maxOffset = (avaToDisplay.size - 1) * step
        avaToDisplay.forEachIndexed { i, url ->
            UserAvatar(urlImage = url,
                online = false,
                drawBorder = true,
                xOffset = (maxOffset - i * step).dp
            )
        }
        if (urls.size > maxAvatars) {
            val plusText = urls.size - maxAvatars
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
