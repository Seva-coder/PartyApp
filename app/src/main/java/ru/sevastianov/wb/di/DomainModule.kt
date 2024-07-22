package ru.sevastianov.wb.di

import org.koin.dsl.module
import ru.sevastianov.domain.usecases.GetActiveEventsUseCase
import ru.sevastianov.domain.usecases.GetAllEventsUseCase
import ru.sevastianov.domain.usecases.GetAllGroupsUseCase
import ru.sevastianov.domain.usecases.GetEventDetailsUseCase
import ru.sevastianov.domain.usecases.GetGroupDescriptionUseCase
import ru.sevastianov.domain.usecases.GetEventsOfGroupUseCase
import ru.sevastianov.domain.usecases.GetOldEventsUseCase
import ru.sevastianov.domain.usecases.GetPlannedEventsUseCase
import ru.sevastianov.domain.usecases.GetUserProfileUseCase
import ru.sevastianov.domain.usecases.IGetActiveEventsUseCase
import ru.sevastianov.domain.usecases.IGetAllEventsUseCase
import ru.sevastianov.domain.usecases.IGetAllGroups
import ru.sevastianov.domain.usecases.IGetEventDetails
import ru.sevastianov.domain.usecases.IGetGroupEvents
import ru.sevastianov.domain.usecases.IGetGroupDescription
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
}