package ru.sevastianov.wb.ui.models


internal data class UserCardUI(
    val userId: Long,
    val imageUrl: String,
    val name: String,
    val tagText: String
)