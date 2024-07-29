package ru.sevastianov.domain.stubRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.sevastianov.domain.models.UserProfile
import ru.sevastianov.domain.repository.IUserRepository


class UserStubRepository : IUserRepository {

    override fun getUserProfile(): Flow<UserProfile> {
        val profile = UserProfile(
            name = "Иванов Иван",
            phone = "+77663269682",
            urlAvatar = "https://upload.wikimedia.org/wikipedia/ru/3/31/%D0%92%D0%BE%D0%B5%D0%BD%D0%BA%D0%BE%D0%BC_%D0%97%D0%B0%D1%85%D0%B0%D1%80%D0%BE%D0%B2.jpg",
            linkTwitter = "http://32r.3",
            linkInstagramm = "https://32r.3",
            linkLinkedIn = "http://32r.3eee",
            linkFacebook = "http://8.3"
        )
        return flowOf(profile)
    }

}