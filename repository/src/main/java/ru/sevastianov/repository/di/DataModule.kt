package ru.sevastianov.repository.di

import org.koin.dsl.module
import ru.sevastianov.domain.repository.IEventsRepository
import ru.sevastianov.domain.repository.IGroupsRepository
import ru.sevastianov.domain.repository.IUserRepository
import ru.sevastianov.domain.stubRepositories.EventsStubRepository
import ru.sevastianov.domain.stubRepositories.GroupsStubRepository
import ru.sevastianov.domain.stubRepositories.UserStubRepository
import ru.sevastianov.repository.BuildConfig
import ru.sevastianov.repository.EventsRepository
import ru.sevastianov.repository.GroupsRepository
import ru.sevastianov.repository.UserRepository

// вопрос - можно ли так делать? пока единственное что не нравится - stub-репозитории лежат в домене
// (иначе для тестов их туда не импортировать)
//
// нужно чтобы приложение в debug-версии показывало какие-нибудь данные
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