package ru.sevastianov.wb.ui.elements

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val route: Any,
    val icon: ImageVector
)
