package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Tag
import ru.sevastianov.domain.repository.ITagsRepository


class GetAllTagsUseCase(val repository: ITagsRepository) : IGetAllTagsUseCase {

    private val res = repository.getAllTags()

    override fun execute(): Flow<List<Tag>> {
        return res
    }

}


interface IGetAllTagsUseCase {
    fun execute(): Flow<List<Tag>>
}