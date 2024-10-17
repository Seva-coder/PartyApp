package ru.sevastianov.repository.entities

data class UserWithAvaNameTag(
    val userId: Long,
    val imageUrl: String,
    val name: String,
    val tag: String
)
