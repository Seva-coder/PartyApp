package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sevastianov.wb.ui.theme.PartyAppTheme
import ru.sevastianov.wb.ui.theme.interFamily

@Composable
fun Tag(
    name: String,
    selected: Boolean = false,
    size: TagSize = TagSize.Small,
    onClick: () -> Unit = {}
) {
    val backColor = if (selected) {
        PartyAppTheme.colors.newMainColor
    } else {
        PartyAppTheme.colors.notSelectedColor
    }

    val textColor = if (selected) {
        PartyAppTheme.colors.notSelectedColor
    } else {
        PartyAppTheme.colors.newMainColor
    }

    // стили текста для тэгов в макете безымянные => используются только здесь
    val smallTextStyle = TextStyle(
        color = textColor,
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 17.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    )

    val middleTextStyle = TextStyle(
        color = textColor,
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        lineHeight = 19.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    )

    val bigTextStyle = TextStyle(
        color = textColor,
        fontFamily = interFamily,
        fontWeight = FontWeight.W500,
        fontSize = 22.sp,
        lineHeight = 27.sp,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    )

    val style = when (size) {
        TagSize.Small -> smallTextStyle
        TagSize.Medium -> middleTextStyle
        TagSize.Big -> bigTextStyle
    }

    val hPadding = when (size) {
        TagSize.Small -> 6.dp
        TagSize.Medium -> 8.dp
        TagSize.Big -> 12.dp
    }

    val vPadding = when (size) {
        TagSize.Small -> 3.dp
        TagSize.Medium -> 8.dp
        TagSize.Big -> 10.dp
    }

    Box(
        modifier = Modifier
            .background(color = backColor, shape = RoundedCornerShape(8.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = hPadding, vertical = vPadding),
            text = name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = style,
        )
    }
}

enum class TagSize {
    Small,
    Medium,
    Big
}