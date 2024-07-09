package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme


val btnModifier = Modifier
    .widthIn(min = 85.dp)
    .height(52.dp)

@Composable
fun MainBtn(text: String = "", isEnabled: Boolean = true, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = PartyAppTheme.colors.initialColor,
            disabledContainerColor = PartyAppTheme.colors.initialDisColor,
            disabledContentColor = PartyAppTheme.colors.neutralWhite
        ),
        modifier = modifier
            .widthIn(min = 85.dp)
            .height(52.dp)
            .alpha(if (isEnabled) 1.0f else 0.5f),
        enabled = isEnabled
    ) {
        Text(text = text)
    }
}


@Composable
fun MainOutlineBtn(text: String = "", isEnabled: Boolean = true, iconId: Int? = null, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = PartyAppTheme.colors.initialDisColor
        ),
        border = if (isEnabled) BorderStroke(
            2.dp,
            PartyAppTheme.colors.initialColor
        ) else BorderStroke(2.dp, PartyAppTheme.colors.initialDisColor),
        modifier = btnModifier
            .alpha(if (isEnabled) 1.0f else 0.5f),
        enabled = isEnabled
    ) {
        Row {
            iconId?.let {
                Icon(
                    painter = painterResource(iconId),
                    contentDescription = "icon"
                )
            }
            if (text.isNotBlank()) {
                Text(text = text)
            }

        }
    }
}

@Composable
fun MainTextBtn(text: String = "", isEnabled: Boolean = true, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = PartyAppTheme.colors.initialDisColor
        ),
        modifier = btnModifier.alpha(if (isEnabled) 1.0f else 0.5f),
        enabled = isEnabled
    ) {
        Text(text = text)
    }
}

@Composable
fun HoverBtn(text: String = "", onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = PartyAppTheme.colors.hoverColor
        ),
        modifier = btnModifier
    ) {
        Text(text = text)
    }
}

@Composable
fun HoverOutlinedBtn(text: String = "", onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = PartyAppTheme.colors.hoverColor
        ),
        border = BorderStroke(2.dp, PartyAppTheme.colors.hoverColor),
        modifier = btnModifier
    ) {
        Text(text = text)
    }
}

@Composable
fun HoverTextBtn(text: String = "", onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = PartyAppTheme.colors.hoverColor
        ),
        modifier = btnModifier
    ) {
        Text(text = text)
    }
}