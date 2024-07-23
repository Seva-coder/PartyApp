package ru.sevastianov.wb.ui.models


internal data class EventDetailsUI(
    val chips: List<String> = emptyList(),
    val date: Int = 0,
    val place: String = "",
    val description: String = "",
    val coordinates: CoordinatesUI = CoordinatesUI(0.0, 0.0), // возможно приведёт к лишней анимации карты
    val participants: List<ParticipantUI> = emptyList(),
    val iGoing: Boolean = false
)
