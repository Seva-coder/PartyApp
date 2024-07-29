package ru.sevastianov.repository.di

import org.koin.dsl.module
import ru.sevastianov.domain.repository.IEventsRepository
import ru.sevastianov.domain.repository.IGroupsRepository
import ru.sevastianov.domain.repository.IUserRepository
import ru.sevastianov.domain.stubRepository.EventsStubRepository
import ru.sevastianov.domain.stubRepository.GroupsStubRepository
import ru.sevastianov.domain.stubRepository.UserStubRepository
import ru.sevastianov.repository.BuildConfig
import ru.sevastianov.repository.EventsRepository
import ru.sevastianov.repository.GroupsRepository
import ru.sevastianov.repository.UserRepository

val dataModule = if (BuildConfig.DEBUG) {
    module {
        single<IEventsRepository> { EventsStubRepository() }
        single<IGroupsRepository> { GroupsStubRepository() }
        single<IUserRepository> { UserStubRepository() }
    }
} else {
    module {
        single<IEventsRepository> { EventsRepository(context = get()) }
        single<IGroupsRepository> { GroupsRepository(context = get()) }
        single<IUserRepository> { UserRepository(context = get()) }
    }
}