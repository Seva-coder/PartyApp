package ru.sevastianov.wb.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
data class ColorTheme(
    val background: Color,
    val initialColor: Color,
    val initialDisColor: Color,
    val hoverColor: Color,
    val borderColor: Color,
    val neutralWhite: Color,
    val greyTextColor: Color,
    val greyTextColor2: Color,
    val greyTextColor3: Color,
    val darkTextColor: Color,
    val avaBorderColor: Color,
    val statusColor: Color,
)

val LightScheme = ColorTheme(
    background = Color(0xFFFAFAFA),
    initialColor = Color(0xFF9A41FE),
    initialDisColor = Color(0x7F9A41FE),
    hoverColor = Color(0xFF660EC8),
    borderColor = Color(0xFFF5ECFF),
    neutralWhite = Color(0xFFF7F7FC),
    greyTextColor = Color(0xFFA4A4A4),
    greyTextColor2 = Color(0xFFADB5BD),
    darkTextColor = Color(0xFF29183B),
    avaBorderColor = Color(0xFFD2D5F9),
    statusColor = Color(0xFF2CC069),
    greyTextColor3 = Color(0xFF666666)
)

val DarkScheme = ColorTheme(
    background = Color(0xFF0F0F0F),
    initialColor = Color(0xFF8BC34A),
    initialDisColor = Color(0xFF9AB877),
    hoverColor = Color(0xFFFF9800),
    borderColor = Color(0xFFF5ECFF),
    neutralWhite = Color(0xFF45524E),
    greyTextColor = Color(0xFFA4A4A4),
    greyTextColor2 = Color(0xFFADB5BD),
    darkTextColor = Color(0xFFD6C4E9),
    avaBorderColor = Color(0xFFD2D5F9),
    statusColor = Color(0xFF2CC069),
    greyTextColor3 = Color(0xFF666666)
)

val LocalLightColorScheme = staticCompositionLocalOf {
    LightScheme
}
