package ru.sevastianov.wb.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.sevastianov.domain.usecases.IGetGroupDescription
import ru.sevastianov.domain.usecases.IGetGroupEvents
import ru.sevastianov.wb.ui.extensions.toUI
import ru.sevastianov.wb.ui.models.EventUI
import ru.sevastianov.wb.ui.models.GroupDescriptionUI


class GroupDetailsVM(private val getGroupDescription: IGetGroupDescription, private val getGroupEvents: IGetGroupEvents) : ViewModel() {

    private val eventListFlow = MutableStateFlow<List<EventUI>>(emptyList())
    private val immutableEventsFlow: StateFlow<List<EventUI>> = eventListFlow
    internal fun getListEvents() = immutableEventsFlow


    private val descriptiontFlow = MutableStateFlow(GroupDescriptionUI())
    private val immutableDescriptionFlow: StateFlow<GroupDescriptionUI> = descriptiontFlow
    internal fun getDescription() = immutableDescriptionFlow

    fun setGroupId(id: Long) {
        viewModelScope.launch {
            getGroupDescription.execute(id).collect { description ->
                descriptiontFlow.value = description.toUI()
            }

            getGroupEvents.execute(id).collect { newList ->
                eventListFlow.value = newList.map { it.toUI() }
            }
        }
    }
}