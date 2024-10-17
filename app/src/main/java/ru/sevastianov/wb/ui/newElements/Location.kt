package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun Location(
    modifier: Modifier = Modifier,
    address: String,
    metro: String? = null,
    lat: Double? = null,
    lon: Double? = null
) {
    Column(modifier = modifier) {
        Text(
            text = address,
            style = PartyAppTheme.typography.H2,
            color = PartyAppTheme.colors.newDarkColor
        )
        metro?.let { metroName ->
            Row {
                Spacer(modifier = Modifier.height(4.dp))
                Image(painter = painterResource(id = R.drawable.metro), contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = metroName,
                    style = PartyAppTheme.typography.secondary,
                    color = PartyAppTheme.colors.newDarkColor
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(24.dp)),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.map2), contentDescription = "map"
        )
    }
}