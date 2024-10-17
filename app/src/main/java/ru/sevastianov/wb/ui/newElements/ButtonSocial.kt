package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun ButtonSocial(type: SocialType, onClick: () -> Unit = { }) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .size(52.dp)
            .background(color = PartyAppTheme.colors.newMainColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        val image = when (type) {
            SocialType.Telegram -> R.drawable.telegram
            SocialType.Habr -> R.drawable.habr
        }
        Icon(
            painter = painterResource(id = image),
            contentDescription = "soc network",
            tint = PartyAppTheme.colors.newWhiteColor
        )
    }
}

enum class SocialType {
    Telegram,
    Habr
}