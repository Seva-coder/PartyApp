package ru.sevastianov.wb.di

import org.koin.dsl.module
import ru.sevastianov.domain.usecases.GetActiveEventsUseCase
import ru.sevastianov.domain.usecases.GetAllEventsUseCase
import ru.sevastianov.domain.usecases.GetAllGroups
import ru.sevastianov.domain.usecases.GetEventDetails
import ru.sevastianov.domain.usecases.GetGroupDescription
import ru.sevastianov.domain.usecases.GetEventsOfGroup
import ru.sevastianov.domain.usecases.GetLastEventsUseCase
import ru.sevastianov.domain.usecases.GetPlannedEventsUseCase
import ru.sevastianov.domain.usecases.GetUserProfile
import ru.sevastianov.domain.usecases.IGetActiveEventsUseCase
import ru.sevastianov.domain.usecases.IGetAllEventsUseCase
import ru.sevastianov.domain.usecases.IGetAllGroups
import ru.sevastianov.domain.usecases.IGetEventDetails
import ru.sevastianov.domain.usecases.IGetGroupEvents
import ru.sevastianov.domain.usecases.IGetGroupDescription
import ru.sevastianov.domain.usecases.IGetLastEventsUseCase
import ru.sevastianov.domain.usecases.IGetPlannedEventsUseCase
import ru.sevastianov.domain.usecases.IGetUserProfile
import ru.sevastianov.domain.usecases.ISetGoToEvent
import ru.sevastianov.domain.usecases.SetGoToEvent

val domainModule = module {
    single<IGetAllEventsUseCase> { GetAllEventsUseCase(repository = get()) }
    single<IGetActiveEventsUseCase> { GetActiveEventsUseCase(repository = get()) }
    single<IGetPlannedEventsUseCase> { GetPlannedEventsUseCase(repository = get()) }
    single<IGetLastEventsUseCase> { GetLastEventsUseCase(repository = get()) }
    single<IGetUserProfile> { GetUserProfile(repository = get()) }
    single<IGetAllGroups> { GetAllGroups(repository = get()) }
    single<IGetGroupDescription> { GetGroupDescription(repository = get()) }
    single<IGetGroupEvents> { GetEventsOfGroup(repository = get()) }
    single<IGetGroupDescription> { GetGroupDescription(repository = get()) }
    single<IGetEventDetails> { GetEventDetails(repository = get()) }
    single<ISetGoToEvent> { SetGoToEvent(repository = get()) }
}