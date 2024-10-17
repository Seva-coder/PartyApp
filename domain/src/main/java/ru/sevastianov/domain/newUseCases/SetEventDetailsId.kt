package ru.sevastianov.domain.newUseCases


internal class SetEventDetailsId(private val innerFlow: InnerEventDetailsIds) : ISetEventDetailsId {

    override fun execute(eventId: Long) {
        innerFlow.update(eventId)
    }

}


interface ISetEventDetailsId {
    fun execute(eventId: Long): Unit
}