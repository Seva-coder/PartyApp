package ru.sevastianov.domain.models


data class GroupDescription(
    val imageUrl: String,
    val name: String,
    val description: String,
    val subscribed: Boolean
)
