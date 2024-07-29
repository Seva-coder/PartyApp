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


class GetEventsOfGroupUseCaseTest : KoinTest {

    private lateinit var useCase: IGetGroupEvents
    private val groupId = 4L

    @Before
    fun initRepo() {
        startKoin { modules(domainModule, testRepositoryModule) }
        useCase = get<IGetGroupEvents>()
    }

    @After
    fun stop() {
        stopKoin()
    }

    @Test
    fun eventsListNotEmpty() = runTest {
        useCase.execute(groupId = groupId).collect { list ->
            val result = list.isNotEmpty()
            Assert.assertTrue("Список пустой!", result)
        }
    }

    @Test
    fun namesNotEmpty() = runTest {
        useCase.execute(groupId = groupId).collect { list ->
            val result = list.all { it.title.isNotBlank() }
            Assert.assertTrue("Название пустое!", result)
        }
    }

    @Test
    fun placesNotEmpty() = runTest {
        useCase.execute(groupId = groupId).collect { list ->
            val result = list.all { it.place.isNotBlank() }
            Assert.assertTrue("Название места пустое!", result)
        }
    }

    @Test
    fun urlsAreOk() = runTest {
        useCase.execute(groupId = groupId).collect { list ->
            val result = list.all { it.imageUrl.matches(urlRegex) }
            Assert.assertTrue("url невалидный!", result)
        }
    }

}