package ru.sevastianov.repository.di

import org.koin.dsl.module
import ru.sevastianov.domain.repository.IEventsRepository
import ru.sevastianov.domain.repository.IGroupsRepository
import ru.sevastianov.repository.EventsRepository
import ru.sevastianov.repository.GroupsRepository

val dataModule = module {
    single<IEventsRepository> { EventsRepository(context = get()) }
    single<IGroupsRepository> { GroupsRepository(context = get()) }
}