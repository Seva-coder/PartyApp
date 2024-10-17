package ru.sevastianov.domain.models

data class UserAvaNameTag(
    val userId: Long,
    val imageUrl: String,
    val name: String,
    val tag: String
)
