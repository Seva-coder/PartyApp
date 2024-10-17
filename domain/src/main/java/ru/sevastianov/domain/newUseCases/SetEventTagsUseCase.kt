package ru.sevastianov.domain.newUseCases


internal class SetEventTagsUseCase(val flowSaver: InnerSelectedEventTags) : ISetEventTagsUseCase {

    override fun execute(idsSet: Set<Long>) {
        flowSaver.update(idsSet)
    }

}

interface ISetEventTagsUseCase {
    fun execute(idsSet: Set<Long>): Unit
}