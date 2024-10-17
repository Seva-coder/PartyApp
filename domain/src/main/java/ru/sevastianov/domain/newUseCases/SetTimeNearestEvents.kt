package ru.sevastianov.domain.newUseCases

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


internal class SetTimeNearestEvents : KoinComponent, ISetTimeNearestEvents {

    private val innerNearest: InnerNearestEvents by inject()

    override fun execute(afterTime: Int) {
        innerNearest.update(afterTime)
    }

}


interface ISetTimeNearestEvents {
    fun execute(afterTime: Int): Unit
}