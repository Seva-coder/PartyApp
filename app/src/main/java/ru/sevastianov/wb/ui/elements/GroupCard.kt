package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun GroupCard(imageId: Int, groupName: String, numberPerson: String) {

    Row {
        Column(modifier = Modifier
            .padding(end = 20.dp)
        ) {
            Image(
                painter = painterResource(imageId),
                contentDescription = "group image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Transparent)
            )
        }
        Column(modifier = Modifier
            .fillMaxWidth()
        ) {
            Text(text = groupName,
                style = PartyAppTheme.typography.bodyText1,
                color = PartyAppTheme.colors.darkTextColor,
                modifier = Modifier
                    .padding(vertical = 0.dp)
            )
            Text(text = numberPerson,
                style = PartyAppTheme.typography.metadata1,
                color = PartyAppTheme.colors.greyTextColor2,
                modifier = Modifier
                    .padding(vertical = 0.dp)
            )
        }
    }
}