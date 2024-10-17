package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.repository.IInterestRepository


internal class IsInterestsExist(val repository: IInterestRepository) : IIsInterestsExits {

    private val result = repository.isInterestsExist()

    override fun execute(): Flow<Boolean> {
        return result
    }

}


interface IIsInterestsExits {
    fun execute(): Flow<Boolean>
}