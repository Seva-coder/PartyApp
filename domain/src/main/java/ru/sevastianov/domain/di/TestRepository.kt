package ru.sevastianov.domain.di

import org.koin.dsl.module
import ru.sevastianov.domain.stubRepositories.EventsStubRepository
import ru.sevastianov.domain.stubRepositories.GroupsStubRepository
import ru.sevastianov.domain.stubRepositories.UserStubRepository
import ru.sevastianov.domain.repository.IEventsRepository
import ru.sevastianov.domain.repository.IGroupsRepository
import ru.sevastianov.domain.repository.IUserRepository

val testRepositoryModule = module {
    single<IEventsRepository> { EventsStubRepository() }
    single<IGroupsRepository> { GroupsStubRepository() }
    single<IUserRepository> { UserStubRepository() }
}