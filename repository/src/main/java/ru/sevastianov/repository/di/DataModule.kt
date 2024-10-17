package ru.sevastianov.repository.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module
import ru.sevastianov.domain.repository.IEventsRepository
import ru.sevastianov.domain.repository.IGroupsRepository
import ru.sevastianov.domain.repository.IInterestRepository
import ru.sevastianov.domain.repository.ITagsRepository
import ru.sevastianov.domain.repository.IUserRepository
import ru.sevastianov.repository.DatabaseClass
import ru.sevastianov.repository.Entity2Domain
import ru.sevastianov.repository.EventsRepository
import ru.sevastianov.repository.GroupsRepository
import ru.sevastianov.repository.InterestsRepository
import ru.sevastianov.repository.TagsRepository
import ru.sevastianov.repository.UserRepository
import ru.sevastianov.repository.dao.EventDao
import ru.sevastianov.repository.dao.GroupDao
import ru.sevastianov.repository.dao.InterestDao
import ru.sevastianov.repository.dao.TagDao
import ru.sevastianov.repository.dao.UserDao


val dataModule = module {

    single<DatabaseClass> {
        DatabaseClass.getDatabase(get(), CoroutineScope(SupervisorJob()))
    }

    single<Entity2Domain> { Entity2Domain() }

    single<EventDao> { get<DatabaseClass>().eventDao() }
    single<TagDao> { get<DatabaseClass>().tagDao() }
    single<InterestDao> { get<DatabaseClass>().interestDao() }
    single<UserDao> { get<DatabaseClass>().userDao() }
    single<GroupDao> { get<DatabaseClass>().groupDao() }

    single<IEventsRepository> {
        EventsRepository(
            context = get(),
            eventDao = get(),
            converter = get()
        )
    }
    single<IGroupsRepository> {
        GroupsRepository(
            context = get(),
            groupDao = get(),
            converter = get()
        )
    }
    single<IUserRepository> { UserRepository(context = get(), userDao = get(), converter = get()) }

    single<ITagsRepository> { TagsRepository(context = get(), tagDao = get(), converter = get()) }

    single<IInterestRepository> { InterestsRepository(interestsDao = get()) }
}
