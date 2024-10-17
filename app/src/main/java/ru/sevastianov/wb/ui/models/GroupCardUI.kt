package ru.sevastianov.wb.ui.models

import ru.sevastianov.wb.ui.newElements.JoinState


internal data class GroupCardUI(
    val id: Long,
    val imageUrl: String,
    val name: String,
    val state: JoinState
)