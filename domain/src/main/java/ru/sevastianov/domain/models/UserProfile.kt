package ru.sevastianov.domain.models

data class UserProfile(
    val name: String,
    val phone: String,
    val urlAvatar: String,
    val linkTwitter: String,
    val linkInstagramm: String,
    val linkLinkedIn: String,
    val linkFacebook: String
)