package ru.sevastianov.wb.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.elements.MainBtn
import ru.sevastianov.wb.ui.elements.ShowAvatar
import ru.sevastianov.wb.ui.theme.PartyAppTheme
import ru.sevastianov.wb.ui.viewmodels.CreateUserVM

@Composable
fun CreateUserScreen(vm: CreateUserVM = koinViewModel(), navToMain: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        var btnEnabled by rememberSaveable { mutableStateOf(false) }
        var name by rememberSaveable { mutableStateOf("") }
        var surname by rememberSaveable { mutableStateOf("") }

        Spacer(modifier = Modifier.height(40.dp))
        ShowAvatar(imageId = null, changeAva = true, onClick = { })
        Spacer(modifier = Modifier.height(31.dp))

        InputName(
            hint = stringResource(R.string.name_hint),
            currentText = { text ->
                name = text
                btnEnabled = text.isNotBlank()
            },
            modifier = Modifier
                .padding(horizontal = 6.dp)
                .height(36.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        InputName(
            hint = stringResource(R.string.surname_hint),
            currentText = { text ->
                surname = text
            },
            modifier = Modifier
                .padding(horizontal = 6.dp)
                .height(36.dp)
        )

        MainBtn(
            text = stringResource(R.string.save_btn),
            isEnabled = btnEnabled,
            onClick = {
                vm.createUser(name = name, surname = surname)
                navToMain()
            },
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 48.dp)
                .fillMaxWidth()
        )
    }
}


@Composable
private fun InputName(hint: String, currentText: (String) -> Unit, modifier: Modifier = Modifier) {

    var textState by rememberSaveable {
        mutableStateOf("")
    }

    var showHint by rememberSaveable { mutableStateOf(true) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(color = PartyAppTheme.colors.neutralWhite)
            .onFocusChanged { newFocusState ->
                showHint = (textState.isBlank() && !newFocusState.isFocused)
            },

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        maxLines = 1,
        textStyle = PartyAppTheme.typography.bodyText1.copy(color = PartyAppTheme.colors.darkTextColor),
        value = textState,
        onValueChange = { text ->
            textState = text
            currentText(text)
        },
        decorationBox = { inputField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterVertically)
                ) {
                    if (showHint) {
                        Text(text = hint,
                            style = PartyAppTheme.typography.bodyText1,
                            color = PartyAppTheme.colors.greyTextColor2,
                            modifier = Modifier.align(Alignment.CenterStart)
                        )
                    }
                    inputField()
                }

            }
        }
    )
}
