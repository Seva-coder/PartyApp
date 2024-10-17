package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun ButtonCustom(
    modifier: Modifier = Modifier,
    text: String = "",
    state: ButtonState = ButtonState.Primary,
    onClick: () -> Unit = { },
) {
    val backColorsPrimary = listOf(
        Color(0xFFED3CCA),
        Color(0xFFDF34D2),
        Color(0xFFD02BD9),
        Color(0xFFBF22E1),
        Color(0xFFAE1AE8),
        Color(0xFF9A10F0),
        Color(0xFF8306F7),
        Color(0xFF6600FF),
    )

    val colorBackDisabled = PartyAppTheme.colors.notSelectedColor
    val backLoadingColor = backColorsPrimary

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

    val colorsBackPlus = colorsBackSecondary
    val colorBackStandard = PartyAppTheme.colors.newMainColor

    val textPrimaryColor = PartyAppTheme.colors.newWhiteColor
    val textDisabledColor = PartyAppTheme.colors.newGreyColor2
    val textSecondaryColor = PartyAppTheme.colors.newMainColor
    val textStandardColor = PartyAppTheme.colors.newWhiteColor


    val brush = when (state) {
        ButtonState.Primary -> Brush.linearGradient(
            colors = backColorsPrimary,
            start = Offset.Zero,
            end = Offset.Infinite
        )

        ButtonState.Disabled -> SolidColor(value = colorBackDisabled)
        ButtonState.Loading -> Brush.linearGradient(
            colors = backLoadingColor,
            start = Offset.Zero,
            end = Offset.Infinite
        )

        ButtonState.Secondary -> Brush.linearGradient(
            colors = colorsBackSecondary,
            start = Offset.Zero,
            end = Offset.Infinite
        )

        ButtonState.Standard, ButtonState.Subscribed -> SolidColor(value = colorBackStandard)
        ButtonState.Plus -> Brush.linearGradient(
            colors = colorsBackPlus,
            start = Offset.Zero,
            end = Offset.Infinite
        )
    }

    val shape = RoundedCornerShape(6.dp)

    Button(
        modifier = modifier
            .background(brush = brush, shape = shape),
        onClick = onClick,
        enabled = state != ButtonState.Disabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = colorBackDisabled
        )
    ) {
        when (state) {
            ButtonState.Primary -> Text(
                text = text,
                style = PartyAppTheme.typography.H3,
                color = textPrimaryColor
            )

            ButtonState.Disabled -> Text(
                text = text,
                style = PartyAppTheme.typography.H3,
                color = textDisabledColor
            )

            ButtonState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = PartyAppTheme.colors.newWhiteColor,
                    trackColor = Color.Transparent,
                    strokeWidth = 2.dp
                )
            }

            ButtonState.Secondary -> Text(
                text = text,
                style = PartyAppTheme.typography.primary,
                color = textSecondaryColor
            )

            ButtonState.Standard -> Text(
                text = text,
                style = PartyAppTheme.typography.primary,
                color = textStandardColor
            )

            ButtonState.Plus -> {
                Image(painter = painterResource(R.drawable.add), contentDescription = "subscribe")
            }

            ButtonState.Subscribed -> {
                Image(painter = painterResource(R.drawable.done), contentDescription = "subscribed")
            }
        }
    }
}


enum class ButtonState {
    Primary,
    Disabled,
    Loading,
    Secondary,
    Standard,
    Plus,
    Subscribed
}