package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun SmsCodeField(
    maxLength: Int = 4,
    modifier: Modifier = Modifier,
    codeInputed: (String) -> Unit = {  }) {

    var textState by rememberSaveable {
        mutableStateOf("")
    }

    val circleColor = PartyAppTheme.colors.dividerColor
    BasicTextField(
        modifier = modifier
            .width(40.dp),
        value = textState,
        onValueChange = {
            if (it.matches(regex = Regex("[0-9]{0,$maxLength}"))) {
                textState = it
            }

            if(it.length == maxLength) {
                codeInputed(it)
            }
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        decorationBox = { innerField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                val charsNumber = textState.length
                repeat(charsNumber) { index ->
                    Text(text = textState[index].toString(),
                        color = PartyAppTheme.colors.darkTextColor,
                        style = PartyAppTheme.typography.heading1,
                        modifier = Modifier
                            .width(32.dp)
                            .height(40.dp)
                    )
                }
                val emptyPlaces = maxLength - charsNumber
                repeat(emptyPlaces) {
                    Canvas(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(32.dp)
                            .height(40.dp)
                    ) {
                        val canvasWidth = size.width
                        val canvasHeight = size.height
                        drawCircle(
                            color = circleColor,
                            radius = 12.dp.toPx(),
                            center = Offset(canvasWidth * 0.5f, canvasHeight * 0.5f)
                        )
                    }
                }
            }
            //innerField() - will be custom field
        }
    )
}