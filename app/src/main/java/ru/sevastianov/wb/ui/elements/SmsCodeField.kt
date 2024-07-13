package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.then
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun SmsCodeField(
    maxLength: Int = 4,
    modifier: Modifier = Modifier,
    codeInputed: (String) -> Unit = {  }) {
    val state = rememberTextFieldState()
    state.edit {
        if(this.length == maxLength) {
            codeInputed(state.text.toString())
        }
    }
    BasicTextField(
        modifier = modifier,
        state = state,
        inputTransformation = InputTransformCode.then(InputTransformation.maxLength(maxLength)),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        decorator = { innerField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                val charsNumber = state.text.length
                repeat(charsNumber) { index ->
                    Text(text = state.text[index].toString(),
                        color = PartyAppTheme.colors.darkTextColor,
                        style = PartyAppTheme.typography.heading1,
                        modifier = Modifier.width(24.dp)
                    )
                }
                val emptyPlaces = maxLength - charsNumber
                repeat(emptyPlaces) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(24.dp)
                            .background(color = PartyAppTheme.colors.dividerColor, shape = CircleShape)
                    )

                }
            }
            //innerField() - will be custom field
        }
    )
}

object InputTransformCode : InputTransformation {
    override fun TextFieldBuffer.transformInput() {
        if (!this.asCharSequence().matches(regex = Regex("[0-9]*"))) {
            this.revertAllChanges()
        }
    }
}