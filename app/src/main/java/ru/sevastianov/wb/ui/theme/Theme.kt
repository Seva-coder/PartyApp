package ru.sevastianov.wb.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider



@Composable
fun PartyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {

    val colorScheme = when {
        darkTheme -> DarkScheme
        else -> LightScheme
    }

    CompositionLocalProvider(
        LocalLightColorScheme provides colorScheme,
        LocalTypography provides PartyTypographyValue,
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object PartyAppTheme {
    val colors: ColorTheme
        @Composable get() = LocalLightColorScheme.current

    val typography: PartyTypography
        @Composable get() = LocalTypography.current

}
