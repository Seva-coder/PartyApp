package ru.sevastianov.repository

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.repository.IInterestRepository
import ru.sevastianov.repository.dao.InterestDao


class InterestsRepository(private val interestsDao: InterestDao) : IInterestRepository {

    override fun isInterestsExist(): Flow<Boolean> {
        return interestsDao.isInterestsExist()
    }

}