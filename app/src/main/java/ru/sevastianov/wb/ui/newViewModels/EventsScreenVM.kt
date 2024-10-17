package ru.sevastianov.wb.ui.newViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.Tag
import ru.sevastianov.domain.newUseCases.IGetAllEventsFlow
import ru.sevastianov.domain.newUseCases.IGetAllTagsUseCase
import ru.sevastianov.domain.newUseCases.IGetBigEventsFlow
import ru.sevastianov.domain.newUseCases.IGetEventsFlowByTags
import ru.sevastianov.domain.newUseCases.IGetFiltredEventsFlow
import ru.sevastianov.domain.newUseCases.IGetNearestEventsFlow
import ru.sevastianov.domain.newUseCases.IIsInterestsExits
import ru.sevastianov.domain.newUseCases.ISetEventTagsUseCase
import ru.sevastianov.domain.newUseCases.ISetTextFilterEvents
import ru.sevastianov.domain.newUseCases.ISetTimeNearestEvents
import ru.sevastianov.wb.Domain2Ui
import ru.sevastianov.wb.ui.models.EventCardUI


internal class EventsScreenVM(
    getBigEvents: IGetBigEventsFlow,
    getNearestEvents: IGetNearestEventsFlow,
    updNearest: ISetTimeNearestEvents,
    getAllTags: IGetAllTagsUseCase,
    getAllEvents: IGetAllEventsFlow,
    getEventsByTags: IGetEventsFlowByTags,
    private val setEventTags: ISetEventTagsUseCase,
    private val filterEventsByText: ISetTextFilterEvents,
    getFiltredEvents: IGetFiltredEventsFlow,
    val interestsExist: IIsInterestsExits,
    val converter: Domain2Ui
) : ViewModel() {

    init {
        updNearest.execute((System.currentTimeMillis() / 1000L).toInt())
    }

    private val bigEventsListFlow = getBigEvents.execute()
    private val nearestEventsListFlow = getNearestEvents.execute()
    private val allTags = getAllTags.execute()

    private val searchingActive = MutableStateFlow(false)
    private val enabledTags = MutableStateFlow(emptySet<Long>())

    private val interestsExistFlow = interestsExist.execute()

    private val eventsFeedSwitcher = MutableStateFlow(FilterSwitch.ALL_EVENTS)

    private enum class FilterSwitch {
        ALL_EVENTS,
        FILTRED_BY_TAGS,
        FILTER_BY_TEXT
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private val mainEventsFlow = eventsFeedSwitcher.flatMapLatest {
        when (it) {
            FilterSwitch.ALL_EVENTS -> getAllEvents.execute()
            FilterSwitch.FILTRED_BY_TAGS -> getEventsByTags.execute()
            FilterSwitch.FILTER_BY_TEXT -> getFiltredEvents.execute()
        }
    }.map {
        it.map { event -> converter.event2ui(event) }
    }

    fun filterBySearchBlock(text: String) {
        if (text.isNotBlank()) {
            searchingActive.tryEmit(true)
            eventsFeedSwitcher.tryEmit(FilterSwitch.FILTER_BY_TEXT)
            filterEventsByText.execute(text)
        } else {
            searchingActive.tryEmit(false)
            eventsFeedSwitcher.tryEmit(FilterSwitch.ALL_EVENTS)
            enabledTags.update {
                emptySet()
            }
        }
    }

    fun updateEnabledTags(newSet: Set<Long>) {
        enabledTags.update {
            newSet
        }
        setEventTags.execute(newSet)
        if (newSet.isEmpty()) {
            eventsFeedSwitcher.tryEmit(FilterSwitch.ALL_EVENTS)
        } else {
            eventsFeedSwitcher.tryEmit(FilterSwitch.FILTRED_BY_TAGS)
        }
    }

    private val screenStateFlow = combine(
        bigEventsListFlow,
        nearestEventsListFlow,
        allTags,
        searchingActive,
        enabledTags,
        mainEventsFlow,
        interestsExistFlow,
    ) { allFlows ->
        val bigEvents = allFlows[0] as? List<Event> ?: emptyList()
        val nearestEvents = allFlows[1] as? List<Event> ?: emptyList()
        val allTags = allFlows[2] as? List<Tag> ?: emptyList()
        val searchingActive = allFlows[3] as? Boolean ?: false
        val enabledTags = allFlows[4] as? Set<Long> ?: emptySet()
        val mainEventsList = allFlows[5] as? List<EventCardUI> ?: emptyList()
        val interestsExist = allFlows[6] as? Boolean ?: false
        converter.combineEventsList2UI(
            bigEvents = bigEvents,
            nearestEvents = nearestEvents,
            allTags = allTags,
            searchingActive = searchingActive,
            enabledTags = enabledTags,
            mainEventsList = mainEventsList,
            interestsExist = interestsExist
        )
    }

    fun getScreenState() = screenStateFlow

}