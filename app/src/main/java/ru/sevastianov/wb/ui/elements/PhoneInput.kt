package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldBuffer
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun PhoneInput(
    modifier: Modifier = Modifier,
    requiredLength: Int = 10,
    currentNumber: (String) -> Unit = {  },
    numberIsReady: (Boolean) -> Unit = {}
) {
    var showDropdown by rememberSaveable { mutableStateOf(false) }
    var countryPrefix by rememberSaveable { mutableStateOf(Country.Rus) }
    val state = rememberTextFieldState()
    var prefixActiveColor by rememberSaveable { mutableStateOf(false) }

    state.edit {
        currentNumber("${countryPrefix.prefix}${state.text}")
        prefixActiveColor = state.text.isNotBlank()

        numberIsReady(this.length == requiredLength)
    }

    var showHint by rememberSaveable { mutableStateOf(true) }

    Row(modifier = modifier
        .height(36.dp)
    ) {

        FlagPrefix(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .clickable { showDropdown = !showDropdown },
            country = countryPrefix,
            active = prefixActiveColor
        )
        DropdownMenu(
            expanded = showDropdown,
            onDismissRequest = { showDropdown = false },
            modifier = Modifier
                .background(PartyAppTheme.colors.dividerColor),
        ) {
            Country.entries.forEach { country ->
                DropdownMenuItem(
                    modifier = Modifier.background(color = PartyAppTheme.colors.dividerColor),
                    text = {
                        FlagPrefix(country = country, active = true)
                    },
                    onClick = {
                        countryPrefix = country
                        showDropdown = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        BasicTextField(state = state,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            inputTransformation = InputTransformPhone(requiredLength),
            outputTransformation = PhoneNumberOutputTransformation,
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .clip(RoundedCornerShape(4.dp))
                .background(color = PartyAppTheme.colors.dividerColor)
                .onFocusChanged { newFocusState ->
                    showHint = (state.text.isEmpty() && !newFocusState.isFocused)
                },
            textStyle = PartyAppTheme.typography.bodyText1.copy(color = PartyAppTheme.colors.darkTextColor),
            decorator = { inputField ->
                Box(contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 10.dp)
                ) {
                    if (showHint) {
                        Text(text = "000 000-00-00",
                            style = PartyAppTheme.typography.bodyText1,
                            color = PartyAppTheme.colors.greyTextColor2,
                            modifier = Modifier.align(Alignment.CenterStart)
                        )
                    } else {
                        inputField()
                    }
                }
            }
        )
    }
}


@Composable
private fun FlagPrefix(
    modifier: Modifier = Modifier,
    country: Country,
    active: Boolean
) {
    val textColor = if (active) PartyAppTheme.colors.darkTextColor else PartyAppTheme.colors.greyTextColor2
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .width(65.dp)
            .fillMaxHeight()
            .background(color = PartyAppTheme.colors.dividerColor)
    ) {
        Image(painter = painterResource(id = country.flagImageId), contentDescription = null)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = country.prefix,
            style = PartyAppTheme.typography.bodyText1,
            color = textColor)
    }
}

class InputTransformPhone(val requiredLength: Int) : InputTransformation {
    override fun TextFieldBuffer.transformInput() {
        if (!this.asCharSequence().matches(regex = Regex("[0-9]{0,$requiredLength}"))) {
            this.revertAllChanges()
        }
    }
}

object PhoneNumberOutputTransformation : OutputTransformation {
    private const val POSITION_3 = 3
    private const val POSITION_7 = 7
    private const val POSITION_10 = 10

    override fun TextFieldBuffer.transformOutput() {
        if (length > POSITION_3) insert(POSITION_3, " ")
        if (length > POSITION_7) insert(POSITION_7, "-")
        if (length > POSITION_10) insert(POSITION_10, "-")
    }
}

enum class Country(val prefix: String, val flagImageId: Int) {
    Rus(prefix = "+7", flagImageId = R.drawable.ru),
    En(prefix = "+44", flagImageId = R.drawable.gb),
    Kz(prefix = "+123", flagImageId = R.drawable.kz)
}