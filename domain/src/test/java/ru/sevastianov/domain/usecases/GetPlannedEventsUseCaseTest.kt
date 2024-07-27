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
        val currentUnixTime = System.currentTimeMillis() / 1000
        useCase.execute().collect { list ->
            Assert.assertTrue("Есть прошлое событие!", list.all { event -> event.date > currentUnixTime })
        }
    }

    @Test
    fun eventsListNotEmpty() = runTest {
        useCase.execute().collect { list ->
            Assert.assertTrue("Список пустой!", list.isNotEmpty())
        }
    }

    @Test
    fun namesNotEmpty() = runTest {
        useCase.execute().collect { list ->
            Assert.assertTrue("Название пустое!", list.all { it.title.isNotBlank() })
        }
    }

    @Test
    fun placeNotEmpty() = runTest {
        useCase.execute().collect { list ->
            Assert.assertTrue("Место пустое!", list.all { it.place.isNotBlank() })
        }
    }

    @Test
    fun urlNotEmpty() = runTest {
        useCase.execute().collect { list ->
            Assert.assertTrue("URL не валидный!", list.all { it.imageUrl.matches(urlRegex) })
        }
    }

}