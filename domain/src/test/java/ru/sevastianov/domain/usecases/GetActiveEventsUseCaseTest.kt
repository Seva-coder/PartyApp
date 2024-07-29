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


class GetActiveEventsUseCaseTest : KoinTest {

    private lateinit var useCase: IGetActiveEventsUseCase

    @Before
    fun initRepo() {
        startKoin { modules(domainModule, testRepositoryModule) }
        useCase = get<IGetActiveEventsUseCase>()
    }

    @After
    fun stop() {
        stopKoin()
    }

    @Test
    fun haveFutureEvent() = runTest {
        val millisInSecond = 1000
        val currentUnixTimeSec = System.currentTimeMillis() / millisInSecond
        useCase.execute().collect { list ->
            val result = list.any { event -> event.date > currentUnixTimeSec }
            Assert.assertTrue("Нет новых событий!", result)
        }
    }

    @Test
    fun eventsListNotEmpty() = runTest {
        useCase.execute().collect { list ->
            val result = list.isNotEmpty()
            Assert.assertTrue("Список пустой!", result)
        }
    }

    @Test
    fun namesNotEmpty() = runTest {
        useCase.execute().collect { list ->
            val result = list.all { it.title.isNotBlank() }
            Assert.assertTrue("Название пустое!", result)
        }
    }

    @Test
    fun placeNotEmpty() = runTest {
        useCase.execute().collect { list ->
            val result = list.all { it.place.isNotBlank() }
            Assert.assertTrue("Место пустое!", result)
        }
    }

    @Test
    fun urlMatchesBasicRegex() = runTest {
        useCase.execute().collect { list ->
            val result = list.all { it.imageUrl.matches(urlRegex) }
            Assert.assertTrue("URL не валидный!", result)
        }
    }
}
