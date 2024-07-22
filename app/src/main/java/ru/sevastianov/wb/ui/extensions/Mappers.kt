package ru.sevastianov.wb.ui.extensions

import ru.sevastianov.domain.models.Event
import ru.sevastianov.wb.ui.models.EventUI

fun Event.toUI() = EventUI(
    title = this.title,
    date = this.date,
    place = this.place,
    tags = this.tags,
    imageUrl = this.imageUrl,
    isEnded = this.isEnded
)