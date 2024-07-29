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


class GetPlannedEventsUseCaseTest : KoinTest {

    private lateinit var useCase: IGetPlannedEventsUseCase

    @Before
    fun initRepo() {
        startKoin { modules(domainModule, testRepositoryModule) }
        useCase = get<IGetPlannedEventsUseCase>()
    }

    @After
    fun stop() {
        stopKoin()
    }

    @Test
    fun allEventsAreFuture() = runTest {
        val millisInSecondSec = 1000
        val currentUnixTimeSec = System.currentTimeMillis() / millisInSecondSec
        useCase.execute().collect { list ->
            val result = list.all { event -> event.date > currentUnixTimeSec }
            Assert.assertTrue("Есть прошлое событие!", result)
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
    fun urlMatchBasicRegex() = runTest {
        useCase.execute().collect { list ->
            val result = list.all { it.imageUrl.matches(urlRegex) }
            Assert.assertTrue("URL не валидный!", result)
        }
    }

}