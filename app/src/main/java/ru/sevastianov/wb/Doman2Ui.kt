package ru.sevastianov.wb

import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.EventDetailsDomain
import ru.sevastianov.domain.models.GroupDescription
import ru.sevastianov.domain.models.ParticipantAvatar
import ru.sevastianov.domain.models.Tag
import ru.sevastianov.domain.models.UserAvaNameTag
import ru.sevastianov.wb.ui.models.EventCardUI
import ru.sevastianov.wb.ui.models.EventDetailsState
import ru.sevastianov.wb.ui.models.EventsListState
import ru.sevastianov.wb.ui.models.TagUI
import ru.sevastianov.wb.ui.models.UserCardUI
import ru.sevastianov.wb.ui.newElements.SubscribeState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


internal class Domain2Ui {
    private val format = SimpleDateFormat("dd MMMM", Locale.getDefault())
    private val formatLong = SimpleDateFormat("dd MMMM, HH:mm", Locale.getDefault())

    internal fun event2ui(input: Event): EventCardUI {

        val date = Date(input.date * 1000L)

        return EventCardUI(
            id = input.eventId,
            name = input.title,
            imageUrl = input.imageUrl,
            date = format.format(date),
            place = input.place,
            tags = input.tags
        )
    }

    internal fun tag2ui(input: Tag): TagUI {
        return TagUI(
            id = input.id,
            name = input.name
        )
    }

    internal fun combineDetails2UI(
        details: EventDetailsDomain,
        group: GroupDescription,
        sameEventsList: List<Event>,
        usersList: List<ParticipantAvatar>,
        buttonState: SubscribeState
    ): EventDetailsState {

        val date = Date(details.dateUnix * 1000L)

        return EventDetailsState(
            eventName = details.name,
            eventImageUrl = details.logoUrl,
            dateUnix = details.dateUnix,
            dateStr = formatLong.format(date),
            place = details.place,
            tagsList = details.tags,
            eventDescription = details.description,
            speakerName = details.speakerName,
            speakerDescription = details.speakerDescription,
            speakerImageUrl = details.speakerImg,
            metroName = details.metroName,
            avatarsList = usersList.map { it.imageUrl },
            organizerName = group.name,
            organizerDescription = group.description,
            organizerImageUrl = group.imageUrl,
            subscribedToGroup = group.subscribed,
            sameEvents = sameEventsList.map { event2ui(it) },
            freeSpaces = details.freeSpaces,
            subscription = buttonState,
            lat = details.lat,
            lon = details.lon
        )
    }

    internal fun combineEventsList2UI(
        bigEvents: List<Event>,
        nearestEvents: List<Event>,
        allTags: List<Tag>,
        searchingActive: Boolean,
        enabledTags: Set<Long>,
        mainEventsList: List<EventCardUI>,
        interestsExist: Boolean
    ): EventsListState {
        return EventsListState(
            bigEvents = bigEvents.map { event2ui(it) },
            nearestEvents = nearestEvents.map { event2ui(it) },
            allTags = allTags.map { tag2ui(it) },
            searchingActive = searchingActive,
            enabledTags = enabledTags,
            mainEventsList = mainEventsList,
            interestsExist = interestsExist
        )
    }

    internal fun user2UI(input: UserAvaNameTag): UserCardUI {
        return UserCardUI(
            imageUrl = input.imageUrl,
            name = input.name,
            tagText = input.tag,
            userId = input.userId
        )
    }

}