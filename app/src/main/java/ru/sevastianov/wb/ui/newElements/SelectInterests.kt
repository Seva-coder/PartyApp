package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.theme.PartyAppTheme
import ru.sevastianov.wb.ui.theme.interFamily


@Composable
fun SelectInterests(modifier: Modifier = Modifier, onClick: () -> Unit = { }) {
    Box(modifier = modifier
        .clickable { onClick() }
    ) {
        val colorsBackSecondary = listOf(
            Color(0xFFFEF1FB),
            Color(0xFFFDF1FC),
            Color(0xFFFCF0FC),
            Color(0xFFFBF0FD),
            Color(0xFFF9EFFD),
            Color(0xFFF8EEFE),
            Color(0xFFF6EEFE),
            Color(0xFFF4EDFF),
        )
        val brush = Brush.linearGradient(
            colors = colorsBackSecondary,
            start = Offset.Zero,
            end = Offset.Infinite
        )

        Image(
            modifier = modifier,
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.interests_back),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .width(224.dp)
                .offset(10.dp, 10.dp),
            text = stringResource(R.string.interests_label),
            style = PartyAppTheme.typography.secondary,
            color = PartyAppTheme.colors.newWhiteColor
        )

        Text( // и опять кастомный стиль, используемый только здесь
            modifier = Modifier
                .offset(10.dp, 75.dp)
                .background(brush = brush, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            text = stringResource(R.string.interests_button_label),
            fontFamily = interFamily,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.W500,
            color = PartyAppTheme.colors.newMainColor
        )

    }
}