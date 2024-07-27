package ru.sevastianov.domain.usecases

import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import ru.sevastianov.domain.di.domainModule
import ru.sevastianov.domain.di.testRepositoryModule


class GetEventDetailsUseCaseTest : KoinTest {

    private lateinit var useCase: IGetEventDetails

    private val eventId = 1L

    @Before
    fun initRepo() {
        startKoin { modules(domainModule, testRepositoryModule) }
        useCase = get<IGetEventDetails>()
    }

    @After
    fun stop() {
        stopKoin()
    }

    @Test
    fun placeNotEmpty() = runTest {
        useCase.execute(eventId = eventId).collect {
            Assert.assertTrue("Место встерчи пустое!", it.place.isNotBlank())
        }
    }

    @Test
    fun descriptionNotEmpty() = runTest {
        useCase.execute(eventId = eventId).collect {
            Assert.assertTrue("Место встерчи пустое!", it.description.isNotBlank())
        }
    }

    @Test
    fun coordinatesValid() = runTest {
        useCase.execute(eventId = eventId).collect {
            val coordinates = it.coordinates
            val latIsOk = -90.0 <= coordinates.lat && coordinates.lat <= 90.0
            val lonIsOk = -180.0 <= coordinates.lon && coordinates.lon <= 180.0
            Assert.assertTrue("Координаты не валидны!", latIsOk && lonIsOk)
        }
    }

    @Test
    fun participantsUrlsIsOk() = runTest {
        useCase.execute(eventId = eventId).collect {
            Assert.assertTrue(
                "url невалидный!",
                it.participants.all { participant ->  participant.imageUrl.matches(urlRegex) }
            )
        }
    }

}