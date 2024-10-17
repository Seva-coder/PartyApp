package ru.sevastianov.wb.ui.newViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import ru.sevastianov.domain.newUseCases.IGetCurrentEventSubscription
import ru.sevastianov.domain.newUseCases.IGetEventDetailsFlow
import ru.sevastianov.domain.newUseCases.IGetEventUsersAvatars
import ru.sevastianov.domain.newUseCases.IGetGroupDescrByEventId
import ru.sevastianov.domain.newUseCases.IGetGroupEventsByEventId
import ru.sevastianov.domain.newUseCases.ISetEventDetailsId
import ru.sevastianov.domain.newUseCases.ISetEventSubscription
import ru.sevastianov.wb.Domain2Ui
import ru.sevastianov.wb.ui.newElements.SubscribeState


internal class EventDetailVM(
    val eventId: Long,
    setEventId: ISetEventDetailsId,
    getEventDetails: IGetEventDetailsFlow,
    getGroupDescr: IGetGroupDescrByEventId,
    val setEventSubscription: ISetEventSubscription,
    val getCurrentEventSubscription: IGetCurrentEventSubscription,
    val getSameEvents: IGetGroupEventsByEventId,
    val getEventUsers: IGetEventUsersAvatars,
    private val converter: Domain2Ui
) : ViewModel() {

    init {
        setEventId.execute(eventId)
    }

    private val users = getEventUsers.execute()

    private val eventDetailsFlow = getEventDetails.execute()
    private val groupDescr = getGroupDescr.execute()
    private val sameEvents = getSameEvents.execute()

    // Event subscribe button logic:
    // shared - тк это событие, и stateFlow не позволит эмитить одно и тоже
    private val subscribeButtonState = MutableSharedFlow<SubscribeState>(replay = 1)
    private val eventSubsRepository = getCurrentEventSubscription.execute()
        .map { if (it) SubscribeState.SUBSCRIBED else SubscribeState.NOT_SUBSCRIBED }

    private val mergedButtonFlow = merge(subscribeButtonState, eventSubsRepository)

    fun setEventSubscribe(subscription: Boolean) {
        subscribeButtonState.tryEmit(SubscribeState.IN_PROGRESS)
        setEventSubscription.execute(eventId = eventId, setSubscription = subscription)
    }

    private val totalStateFlow =
        combine(eventDetailsFlow, groupDescr, sameEvents, users, mergedButtonFlow)
        { details, group, events, usersList, buttonState ->
            converter.combineDetails2UI(
                details = details,
                group = group,
                sameEventsList = events,
                usersList = usersList,
                buttonState = buttonState
            )
        }

    fun getScreenState() = totalStateFlow

    override fun onCleared() {
        super.onCleared()
        Log.d("CLEARED", "CLEARED")
    }
}