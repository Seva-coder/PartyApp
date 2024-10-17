package ru.sevastianov.domain.di

import org.koin.dsl.module
import ru.sevastianov.domain.newUseCases.BigEventsInnerUseCase
import ru.sevastianov.domain.newUseCases.GetAllBigEventsFlowInteractor
import ru.sevastianov.domain.newUseCases.GetAllEventsFlow
import ru.sevastianov.domain.newUseCases.GetAllTagsUseCase
import ru.sevastianov.domain.newUseCases.GetCurrentEventSubscription
import ru.sevastianov.domain.newUseCases.GetEventDetailsFlow
import ru.sevastianov.domain.newUseCases.GetEventUsers
import ru.sevastianov.domain.newUseCases.GetEventUsersAvatars
import ru.sevastianov.domain.newUseCases.GetEventsFlowByTagsUseCase
import ru.sevastianov.domain.newUseCases.GetFiltredEventsFlow
import ru.sevastianov.domain.newUseCases.GetGroupDescrByEventId
import ru.sevastianov.domain.newUseCases.GetGroupEventsByEventId
import ru.sevastianov.domain.newUseCases.GetNearestEventsFlow
import ru.sevastianov.domain.newUseCases.IGetAllEventsFlow
import ru.sevastianov.domain.newUseCases.IGetAllTagsUseCase
import ru.sevastianov.domain.newUseCases.IGetBigEventsFlow
import ru.sevastianov.domain.newUseCases.IGetCurrentEventSubscription
import ru.sevastianov.domain.newUseCases.IGetEventDetailsFlow
import ru.sevastianov.domain.newUseCases.IGetEventUsers
import ru.sevastianov.domain.newUseCases.IGetEventUsersAvatars
import ru.sevastianov.domain.newUseCases.IGetEventsFlowByTags
import ru.sevastianov.domain.newUseCases.IGetFiltredEventsFlow
import ru.sevastianov.domain.newUseCases.IGetGroupDescrByEventId
import ru.sevastianov.domain.newUseCases.IGetGroupEventsByEventId
import ru.sevastianov.domain.newUseCases.IGetNearestEventsFlow
import ru.sevastianov.domain.newUseCases.IIsInterestsExits
import ru.sevastianov.domain.newUseCases.ISetEventDetailsId
import ru.sevastianov.domain.newUseCases.ISetEventSubscription
import ru.sevastianov.domain.newUseCases.ISetEventTagsUseCase
import ru.sevastianov.domain.newUseCases.ISetTextFilterEvents
import ru.sevastianov.domain.newUseCases.ISetTimeNearestEvents
import ru.sevastianov.domain.newUseCases.InnerEventDetailsIds
import ru.sevastianov.domain.newUseCases.InnerFilteredEvents
import ru.sevastianov.domain.newUseCases.InnerNearestEvents
import ru.sevastianov.domain.newUseCases.InnerSelectedEventTags
import ru.sevastianov.domain.newUseCases.IsInterestsExist
import ru.sevastianov.domain.newUseCases.SetEventDetailsId
import ru.sevastianov.domain.newUseCases.SetEventSubscription
import ru.sevastianov.domain.newUseCases.SetEventTagsUseCase
import ru.sevastianov.domain.newUseCases.SetTextFilterEvents
import ru.sevastianov.domain.newUseCases.SetTimeNearestEvents
import ru.sevastianov.domain.usecases.GetActiveEventsUseCase
import ru.sevastianov.domain.usecases.GetAllEventsUseCase
import ru.sevastianov.domain.usecases.GetAllGroupsUseCase
import ru.sevastianov.domain.usecases.GetEventDetailsUseCase
import ru.sevastianov.domain.usecases.GetEventsOfGroupUseCase
import ru.sevastianov.domain.usecases.GetGroupDescriptionUseCase
import ru.sevastianov.domain.usecases.GetOldEventsUseCase
import ru.sevastianov.domain.usecases.GetPlannedEventsUseCase
import ru.sevastianov.domain.usecases.GetUserProfileUseCase
import ru.sevastianov.domain.usecases.IGetActiveEventsUseCase
import ru.sevastianov.domain.usecases.IGetAllEventsUseCase
import ru.sevastianov.domain.usecases.IGetAllGroups
import ru.sevastianov.domain.usecases.IGetEventDetails
import ru.sevastianov.domain.usecases.IGetGroupDescription
import ru.sevastianov.domain.usecases.IGetGroupEvents
import ru.sevastianov.domain.usecases.IGetOldEventsUseCase
import ru.sevastianov.domain.usecases.IGetPlannedEventsUseCase
import ru.sevastianov.domain.usecases.IGetUserProfile
import ru.sevastianov.domain.usecases.ISetGoToEvent
import ru.sevastianov.domain.usecases.SetGoToEventUseCase

val domainModule = module {
    single<IGetAllEventsUseCase> { GetAllEventsUseCase(repository = get()) }
    single<IGetActiveEventsUseCase> { GetActiveEventsUseCase(repository = get()) }
    single<IGetPlannedEventsUseCase> { GetPlannedEventsUseCase(repository = get()) }
    single<IGetOldEventsUseCase> { GetOldEventsUseCase(repository = get()) }
    single<IGetUserProfile> { GetUserProfileUseCase(repository = get()) }
    single<IGetAllGroups> { GetAllGroupsUseCase(repository = get()) }
    single<IGetGroupDescription> { GetGroupDescriptionUseCase(repository = get()) }
    single<IGetGroupEvents> { GetEventsOfGroupUseCase(repository = get()) }
    single<IGetGroupDescription> { GetGroupDescriptionUseCase(repository = get()) }
    single<IGetEventDetails> { GetEventDetailsUseCase(repository = get()) }
    single<ISetGoToEvent> { SetGoToEventUseCase(repository = get()) }

    ////
    single<BigEventsInnerUseCase> { BigEventsInnerUseCase(repository = get()) }
    single<IGetBigEventsFlow> { GetAllBigEventsFlowInteractor(innerEvents = get()) }

    single<InnerNearestEvents> { InnerNearestEvents() }
    single<ISetTimeNearestEvents> { SetTimeNearestEvents() }
    single<IGetNearestEventsFlow> {
        GetNearestEventsFlow(
            eventsRepository = get(),
            innerNearestTimes = get()
        )
    }

    single<IGetAllTagsUseCase> { GetAllTagsUseCase(repository = get()) }

    single<IGetAllEventsFlow> { GetAllEventsFlow(repository = get()) }

    single<InnerSelectedEventTags> { InnerSelectedEventTags() }
    single<ISetEventTagsUseCase> { SetEventTagsUseCase(flowSaver = get()) }
    single<IGetEventsFlowByTags> { GetEventsFlowByTagsUseCase(repository = get(), idsFlow = get()) }

    single<InnerFilteredEvents> { InnerFilteredEvents() }
    single<ISetTextFilterEvents> { SetTextFilterEvents(flowSaver = get()) }
    single<IGetFiltredEventsFlow> { GetFiltredEventsFlow(repository = get(), textFilter = get()) }

    single<IIsInterestsExits> { IsInterestsExist(repository = get()) }

    single<InnerEventDetailsIds> { InnerEventDetailsIds() }
    single<ISetEventDetailsId> { SetEventDetailsId(innerFlow = get()) }
    single<IGetEventDetailsFlow> { GetEventDetailsFlow(repository = get(), innerIdsFlow = get()) }

    single<IGetGroupDescrByEventId> {
        GetGroupDescrByEventId(
            repository = get(),
            eventsIdsFlow = get()
        )
    }

    single<ISetEventSubscription> { SetEventSubscription(repository = get()) }

    single<IGetCurrentEventSubscription> {
        GetCurrentEventSubscription(
            repository = get(),
            innerIdsFlow = get()
        )
    }

    single<IGetGroupEventsByEventId> {
        GetGroupEventsByEventId(
            repository = get(),
            innerIdsFlow = get()
        )
    }

    single<IGetEventUsersAvatars> { GetEventUsersAvatars(repository = get(), innerIdsFlow = get()) }

    single<IGetEventUsers> { GetEventUsers(repository = get(), innerIdsFlow = get()) }

}