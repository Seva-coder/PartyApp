package ru.sevastianov.repository

import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.EventDetailsDomain
import ru.sevastianov.domain.models.GroupDescription
import ru.sevastianov.domain.models.ParticipantAvatar
import ru.sevastianov.domain.models.Tag
import ru.sevastianov.domain.models.UserAvaNameTag
import ru.sevastianov.repository.entities.EventDetails
import ru.sevastianov.repository.entities.EventWithTags
import ru.sevastianov.repository.entities.GroupEntity
import ru.sevastianov.repository.entities.TagEntity
import ru.sevastianov.repository.entities.UserImage
import ru.sevastianov.repository.entities.UserWithAvaNameTag

class Entity2Domain {

    fun event2domain(input: EventWithTags): Event {
        return Event(
            eventId = input.eventId,
            title = input.name,
            imageUrl = input.logoUrl,
            date = input.date,
            place = input.place,
            tags = input.tags//.map { it.name }
        )
    }

    fun userAvatars2domain(input: UserImage): ParticipantAvatar {
        return ParticipantAvatar(
            imageUrl = input.userAvatarUrl
        )
    }


    fun tag2domain(input: TagEntity): Tag {
        return Tag(
            id = input.tagId,
            name = input.nameTag
        )
    }

    fun eventDetails2domain(eventDetails: EventDetails): EventDetailsDomain {
        return EventDetailsDomain(
            eventId = eventDetails.eventId,
            logoUrl = eventDetails.logoUrl,
            name = eventDetails.name,
            dateUnix = eventDetails.date,
            place = eventDetails.place,
            metroName = eventDetails.metroName,
            description = eventDetails.description,
            iGo = eventDetails.iGo,
            lat = eventDetails.lat,
            lon = eventDetails.lon,
            speakerName = eventDetails.speakerName,
            speakerDescription = eventDetails.speakerDescription,
            speakerImg = eventDetails.speakerImg,
            freeSpaces = eventDetails.freeSpaces,
            tags = eventDetails.tags
        )
    }

    fun group2domain(group: GroupEntity): GroupDescription {
        return GroupDescription(
            imageUrl = group.logoUrl,
            name = group.name,
            description = group.description,
            subscribed = group.subscribed
        )
    }

    fun userInfo2domain(user: UserWithAvaNameTag): UserAvaNameTag {
        return UserAvaNameTag(
            userId = user.userId,
            imageUrl = user.imageUrl,
            name = user.name,
            tag = user.tag
        )
    }
}