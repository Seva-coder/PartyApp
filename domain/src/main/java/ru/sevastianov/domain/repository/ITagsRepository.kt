package ru.sevastianov.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Tag


interface ITagsRepository {

    fun getAllTags(): Flow<List<Tag>>

}
