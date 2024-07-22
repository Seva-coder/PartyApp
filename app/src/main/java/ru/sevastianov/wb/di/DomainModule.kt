package ru.sevastianov.wb.di

import org.koin.dsl.module
import ru.sevastianov.domain.usecases.GetActiveEventsUseCase
import ru.sevastianov.domain.usecases.GetAllEventsUseCase
import ru.sevastianov.domain.usecases.GetLastEventsUseCase
import ru.sevastianov.domain.usecases.GetPlannedEventsUseCase
import ru.sevastianov.domain.usecases.IGetActiveEventsUseCase
import ru.sevastianov.domain.usecases.IGetAllEventsUseCase
import ru.sevastianov.domain.usecases.IGetLastEventsUseCase
import ru.sevastianov.domain.usecases.IGetPlannedEventsUseCase

val domainModule = module {
    single<IGetAllEventsUseCase> { GetAllEventsUseCase(repository = get()) }
    single<IGetActiveEventsUseCase> { GetActiveEventsUseCase(repository = get()) }

    single<IGetPlannedEventsUseCase> { GetPlannedEventsUseCase(repository = get()) }
    single<IGetLastEventsUseCase> { GetLastEventsUseCase(repository = get()) }

}