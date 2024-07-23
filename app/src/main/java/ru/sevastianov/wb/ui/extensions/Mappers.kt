package ru.sevastianov.wb.ui.extensions

import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.EventDetails
import ru.sevastianov.domain.models.Group
import ru.sevastianov.domain.models.GroupDescription
import ru.sevastianov.domain.models.UserProfile
import ru.sevastianov.wb.ui.models.CoordinatesUI
import ru.sevastianov.wb.ui.models.EventDetailsUI
import ru.sevastianov.wb.ui.models.EventUI
import ru.sevastianov.wb.ui.models.GroupDescriptionUI
import ru.sevastianov.wb.ui.models.GroupUI
import ru.sevastianov.wb.ui.models.ParticipantUI
import ru.sevastianov.wb.ui.models.UserProfileUI

internal fun Event.toUI() = EventUI(
    title = this.title,
    date = this.date,
    place = this.place,
    tags = this.tags,
    imageUrl = this.imageUrl,
    isEnded = this.isEnded
)

internal fun UserProfile.toUI() = UserProfileUI(
    name = this.name,
    phone  = this.phone,
    urlAvatar = this.urlAvatar,
    linkTwitter = this.linkTwitter,
    linkInstagramm = this.linkInstagramm,
    linkLinkedIn = this.linkLinkedIn,
    linkFacebook = this.linkFacebook
)

internal fun Group.toUI() = GroupUI(
    imgUrl = this.imgUrl,
    name = this.name,
    numberPerson = this.numberPerson
)

internal fun GroupDescription.toUI() = GroupDescriptionUI(
    description = this.description
)

internal fun EventDetails.toUI() = EventDetailsUI(
    chips = this.chips,
    date = this.date,
    place = this.place,
    coordinates = CoordinatesUI(this.coordinates.lat, this.coordinates.lon),
    description = this.description,
    iGoing = this.iGoing,
    participants = this.participants.map { ParticipantUI(it.imageUrl) }
)