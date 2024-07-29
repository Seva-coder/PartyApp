package ru.sevastianov.domain.di

import org.koin.dsl.module
import ru.sevastianov.domain.repository.IEventsRepository
import ru.sevastianov.domain.repository.IGroupsRepository
import ru.sevastianov.domain.repository.IUserRepository
import ru.sevastianov.domain.stubRepository.EventsStubRepository
import ru.sevastianov.domain.stubRepository.GroupsStubRepository
import ru.sevastianov.domain.stubRepository.UserStubRepository


val testRepositoryModule = module {
    single<IEventsRepository> { EventsStubRepository() }
    single<IGroupsRepository> { GroupsStubRepository() }
    single<IUserRepository> { UserStubRepository() }
}