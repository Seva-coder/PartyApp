package ru.sevastianov.domain.newUseCases


internal class SetTextFilterEvents(private val flowSaver: InnerFilteredEvents) :
    ISetTextFilterEvents {

    override fun execute(text: String) {
        flowSaver.update(text)
    }

}

interface ISetTextFilterEvents {
    fun execute(text: String)
}