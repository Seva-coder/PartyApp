package ru.sevastianov.domain.usecases

import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.get
import ru.sevastianov.domain.di.domainModule
import ru.sevastianov.domain.di.testRepositoryModule


class GetAllGroupsUseCaseTest : KoinTest {

    private lateinit var useCase: IGetAllGroups

    @Before
    fun initRepo() {
        startKoin { modules(domainModule, testRepositoryModule) }
        useCase = get<IGetAllGroups>()
    }

    @After
    fun stop() {
        stopKoin()
    }

    @Test
    fun placeNotEmpty() = runTest {
        useCase.execute().collect { list ->
            Assert.assertTrue("Название группы пустое!", list.all { it.name.isNotBlank() })
        }
    }

    @Test
    fun membersMoreThanZero() = runTest {
        useCase.execute().collect { list ->
            Assert.assertTrue("Участники в группе отсутствуют!", list.all { it.numberPerson > 0 })
        }
    }

    @Test
    fun urlNotValid() = runTest {
        useCase.execute().collect { list ->
            Assert.assertTrue("url некорректный!", list.all { it.imgUrl.matches(urlRegex) })
        }
    }

}