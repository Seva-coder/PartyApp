package ru.sevastianov.wb.ui.elements

import androidx.compose.ui.graphics.vector.ImageVector
import ru.sevastianov.wb.Screen

data class BottomNavItem(
    val name: String,
    val route: Screen,
    val icon: ImageVector
)
