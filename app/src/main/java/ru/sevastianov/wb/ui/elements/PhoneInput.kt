package ru.sevastianov.wb.ui.elements

import android.util.Log
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.KeyboardActionHandler
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
    onEnter: (String) -> Unit = {  }
) {
    var showDropdown by rememberSaveable { mutableStateOf(false) }
    var countryPrefix by rememberSaveable { mutableStateOf(Country.Rus) }
    val state = rememberTextFieldState()
    var showHint by rememberSaveable { mutableStateOf(true) }

    Row(horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
        modifier = modifier
        .height(36.dp)
        .width(327.dp)
    ) {

        FlagPrefix(
            modifier = Modifier
                .width(65.dp)
                .clip(RoundedCornerShape(4.dp))
                .clickable { showDropdown = !showDropdown },
            country = countryPrefix
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
                        FlagPrefix(country = country)
                    },
                    onClick = {
                        countryPrefix = country
                        showDropdown = false
                    }
                )
            }

        }

        BasicTextField(state = state,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done
            ),
            inputTransformation = InputTransformPhone,
            outputTransformation = PhoneNumberOutputTransformation,
            //onKeyboardAction = keyboardHandler  // not work now
            modifier = Modifier
                .fillMaxHeight()
                .width(240.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color = PartyAppTheme.colors.dividerColor)
                .onFocusChanged { newFocusState ->
                    showHint = (state.text.isEmpty() && !newFocusState.isFocused)
                },
            textStyle = PartyAppTheme.typography.bodyText1,
            decorator = { inputField ->
                Box(contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 3.dp)
                ) {
                    if (showHint) {
                        Text(text = "000 000-00-00",
                            style = PartyAppTheme.typography.bodyText1,
                            color = PartyAppTheme.colors.greyTextColor2,
                            modifier = Modifier.align(Alignment.CenterStart)
                        )
                    } else {
                        Box(modifier = Modifier.padding(start = 10.dp)) {
                            inputField()
                        }
                    }
                }
            }
        )

    }

}

object keyboardHandler : KeyboardActionHandler {
    override fun onKeyboardAction(performDefaultAction: () -> Unit) {
        KeyboardActions(
            onDone = {
                Log.d("sd", "sd")
            }).onDone
    }

}

@Composable
private fun FlagPrefix(
    modifier: Modifier = Modifier,
    country: Country
) {
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxHeight()
            .background(color = PartyAppTheme.colors.dividerColor)
    ) {
        Image(painter = painterResource(id = country.flagImageId), contentDescription = null)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = country.prefix,
            style = PartyAppTheme.typography.bodyText1,
            color = PartyAppTheme.colors.greyTextColor2)
    }
}

object InputTransformPhone : InputTransformation {
    override fun TextFieldBuffer.transformInput() {
        if (!this.asCharSequence().matches(regex = Regex("[0-9]{0,10}"))) {
            this.revertAllChanges()
        }
    }
}

object PhoneNumberOutputTransformation : OutputTransformation {
    override fun TextFieldBuffer.transformOutput() {
        if (length > 3) insert(3, " ")
        if (length > 7) insert(7, "-")
        if (length > 10) insert(10, "-")
    }
}

enum class Country(val prefix: String, val flagImageId: Int) {
    Rus(prefix = "+7", flagImageId = R.drawable.ru),
    En(prefix = "+44", flagImageId = R.drawable.gb),
    Kz(prefix = "+123", flagImageId = R.drawable.kz)
}