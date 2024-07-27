package ru.sevastianov.domain.di

import org.koin.dsl.module
import ru.sevastianov.domain.repository.IEventsRepository
import ru.sevastianov.domain.repository.IGroupsRepository
import ru.sevastianov.domain.repository.IUserRepository

val testRepositoryModule = module {
    single<IEventsRepository> { object : IEventsRepository { } }
    single<IGroupsRepository> { object : IGroupsRepository { } }
    single<IUserRepository> { object : IUserRepository { } }
}