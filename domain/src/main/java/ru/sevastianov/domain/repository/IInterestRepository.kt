package ru.sevastianov.domain.repository

import kotlinx.coroutines.flow.Flow


interface IInterestRepository {

    fun isInterestsExist(): Flow<Boolean>

}