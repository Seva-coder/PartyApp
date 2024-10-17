package ru.sevastianov.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.sevastianov.domain.models.Tag
import ru.sevastianov.domain.repository.ITagsRepository
import ru.sevastianov.repository.dao.TagDao


class TagsRepository(
    val context: Context,
    private val tagDao: TagDao,
    private val converter: Entity2Domain
) : ITagsRepository {

    override fun getAllTags(): Flow<List<Tag>> {
        val tags = tagDao.getAllTags()

        val domainFlow = tags.map {
            it.map { tag -> converter.tag2domain(tag) }
        }

        return domainFlow

    }
}