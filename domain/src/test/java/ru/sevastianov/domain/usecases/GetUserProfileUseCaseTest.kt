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


class GetUserProfileUseCaseTest : KoinTest {

    private lateinit var useCase: IGetUserProfile

    @Before
    fun initRepo() {
        startKoin { modules(domainModule, testRepositoryModule) }
        useCase = get<IGetUserProfile>()
    }

    @After
    fun stop() {
        stopKoin()
    }

    @Test
    fun nameNotEmpty() = runTest {
        useCase.execute().collect { userProfile ->
            val result = userProfile.name.isNotBlank()
            Assert.assertTrue("Имя пользователя пустое!", result)
        }
    }

    @Test
    fun phoneValid() = runTest {
        useCase.execute().collect { userProfile ->
            val result = userProfile.phone.matches(phoneRegex)
            Assert.assertTrue("Телефон не валидный!", result)
        }
    }

    @Test
    fun urlAvatarValid() = runTest {
        useCase.execute().collect { userProfile ->
            val result = userProfile.urlAvatar.matches(urlRegex)
            Assert.assertTrue("URL avatar не валидный!", result)
        }
    }

    @Test
    fun urlTwitterValid() = runTest {
        useCase.execute().collect { userProfile ->
            val result = userProfile.linkTwitter.matches(urlRegex)
            Assert.assertTrue("URL Twitter не валидный!", result)
        }
    }

    @Test
    fun urlInstagramValid() = runTest {
        useCase.execute().collect { userProfile ->
            val result = userProfile.linkInstagramm.matches(urlRegex)
            Assert.assertTrue("URL Instagram не валидный!", result)
        }
    }

    @Test
    fun urlLinkedValid() = runTest {
        useCase.execute().collect { userProfile ->
            val result = userProfile.linkLinkedIn.matches(urlRegex)
            Assert.assertTrue("URL Linked не валидный!", result)
        }
    }

    @Test
    fun urlFacebookValid() = runTest {
        useCase.execute().collect { userProfile ->
            val result = userProfile.linkFacebook.matches(urlRegex)
            Assert.assertTrue("URL Facebook не валидный!", result)
        }
    }

}