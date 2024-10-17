package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import ru.sevastianov.domain.models.Event


internal class GetAllBigEventsFlowInteractor(private val innerEvents: BigEventsInnerUseCase) :
    IGetBigEventsFlow, KoinComponent {

    //private val innerEvents: BigEventsInnerUseCase by inject()  // это single, всегда один и тот же экземпляр

    override fun execute(): Flow<List<Event>> {
        return innerEvents.getBigEventsFlow()
    }
}


interface IGetBigEventsFlow {
    fun execute(): Flow<List<Event>>
}