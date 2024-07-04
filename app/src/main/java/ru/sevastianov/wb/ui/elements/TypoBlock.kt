package ru.sevastianov.wb.ui.elements

import androidx.compose.runtime.Composable
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun TypoBlock() {
    val commonText = "The quick brown fox jumps over the lazy dog"

    TypographyRow(title = "Heading 1", subTitle = "SF Pro Display/32/Bold", text = commonText, style = PartyAppTheme.typography.heading1)
    TypographyRow(title = "Heading 2", subTitle = "SF Pro Display24/Bold", text = commonText, style = PartyAppTheme.typography.heading2)
    TypographyRow(title = "Subheading 1", subTitle = "SF Pro Display18/SemiBold", text = commonText, style = PartyAppTheme.typography.subheading1)
    TypographyRow(title = "Subheading 2", subTitle = "SF Pro Display16/SemiBold", text = commonText, style = PartyAppTheme.typography.subheading2)
    TypographyRow(title = "Body Text 1", subTitle = "SF Pro Display/14/SemiBold", text = commonText, style = PartyAppTheme.typography.bodyText1)
    TypographyRow(title = "Body Text 2", subTitle = "SF Pro Display14/Regular", text = commonText, style = PartyAppTheme.typography.bodyText2)
    TypographyRow(title = "Metadata 1", subTitle = "SF Pro Display12/Regular", text = commonText, style = PartyAppTheme.typography.metadata1)
    TypographyRow(title = "Metadata 2", subTitle = "SF Pro Display10/Regular", text = commonText, style = PartyAppTheme.typography.metadata2)
    TypographyRow(title = "Metadata 3", subTitle = "SF Pro Display10/SemiBold", text = commonText, style = PartyAppTheme.typography.metadata3)
}