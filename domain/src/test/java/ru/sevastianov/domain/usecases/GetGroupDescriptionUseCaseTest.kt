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


class GetGroupDescriptionUseCaseTest : KoinTest {

    private lateinit var useCase: IGetGroupDescription
    private val groupId = 1L

    @Before
    fun initRepo() {
        startKoin { modules(domainModule, testRepositoryModule) }
        useCase = get<IGetGroupDescription>()
    }

    @After
    fun stop() {
        stopKoin()
    }

    @Test
    fun descriptionNotEmpty() = runTest {
        useCase.execute(groupId = groupId).collect {
            val result = it.description.isNotBlank()
            Assert.assertTrue("Описание пустое!", result)
        }
    }

}