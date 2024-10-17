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


class GetEventDetailsDomainUseCaseTest : KoinTest {

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
            val result = it.place.isNotBlank()
            Assert.assertTrue("Место встерчи пустое!", result)
        }
    }

    @Test
    fun descriptionNotEmpty() = runTest {
        useCase.execute(eventId = eventId).collect {
            val result = it.description.isNotBlank()
            Assert.assertTrue("Место встерчи пустое!", result)
        }
    }

    @Test
    fun coordinatesValid() = runTest {
        useCase.execute(eventId = eventId).collect {
            val coordinates = it.coordinates
            val latIsOk = -90.0 <= coordinates.lat && coordinates.lat <= 90.0
            val lonIsOk = -180.0 <= coordinates.lon && coordinates.lon <= 180.0
            val result = latIsOk && lonIsOk
            Assert.assertTrue("Координаты не валидны!", result)
        }
    }

    @Test
    fun participantsUrlsIsOk() = runTest {
        useCase.execute(eventId = eventId).collect {
            val result =
                it.participants.all { participant -> participant.imageUrl.matches(urlRegex) }
            Assert.assertTrue("url невалидный!", result)
        }
    }

}