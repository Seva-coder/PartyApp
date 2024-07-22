package ru.sevastianov.wb.di

import org.koin.dsl.module
import ru.sevastianov.domain.repository.IEventsRepository
import ru.sevastianov.repository.EventsRepository

val dataModule = module {
    single<IEventsRepository> { EventsRepository(context = get()) }
}