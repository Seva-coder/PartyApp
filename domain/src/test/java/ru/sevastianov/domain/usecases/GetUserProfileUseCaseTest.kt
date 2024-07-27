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
            Assert.assertTrue("Имя пользователя пустое!", userProfile.name.isNotBlank())
        }
    }

    @Test
    fun phoneValid() = runTest {
        useCase.execute().collect { userProfile ->
            Assert.assertTrue("Телефон не валидный!", userProfile.phone.matches(phoneRegex) )
        }
    }

    @Test
    fun urlAvatarValid() = runTest {
        useCase.execute().collect { userProfile ->
            Assert.assertTrue("URL avatar не валидный!", userProfile.urlAvatar.matches(urlRegex) )
        }
    }

    @Test
    fun urlTwitterValid() = runTest {
        useCase.execute().collect { userProfile ->
            Assert.assertTrue("URL Twitter не валидный!", userProfile.linkTwitter.matches(urlRegex) )
        }
    }

    @Test
    fun urlInstagramValid() = runTest {
        useCase.execute().collect { userProfile ->
            Assert.assertTrue("URL Instagram не валидный!", userProfile.linkInstagramm.matches(urlRegex) )
        }
    }

    @Test
    fun urlLinkedValid() = runTest {
        useCase.execute().collect { userProfile ->
            Assert.assertTrue("URL Linked не валидный!", userProfile.linkLinkedIn.matches(urlRegex) )
        }
    }

    @Test
    fun urlFacebookValid() = runTest {
        useCase.execute().collect { userProfile ->
            Assert.assertTrue("URL Facebook не валидный!", userProfile.linkFacebook.matches(urlRegex) )
        }
    }

}