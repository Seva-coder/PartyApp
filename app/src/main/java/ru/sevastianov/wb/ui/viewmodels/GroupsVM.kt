package ru.sevastianov.wb.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.sevastianov.domain.usecases.IGetAllGroups
import ru.sevastianov.wb.ui.extensions.toUI
import ru.sevastianov.wb.ui.models.GroupUI

class GroupsVM(private val getAllGroups: IGetAllGroups) : ViewModel() {

    private val groupsListFlow = MutableStateFlow<List<GroupUI>>(emptyList())
    private val immutableActiveEventsListFlow: StateFlow<List<GroupUI>> = groupsListFlow
    fun getAllGroups() = immutableActiveEventsListFlow

    init {
        updateGroups()
    }

    private fun updateGroups() {
        viewModelScope.launch {
            getAllGroups.execute().collect { newList ->
                groupsListFlow.value = newList.map { it.toUI() }
            }
        }
    }

}