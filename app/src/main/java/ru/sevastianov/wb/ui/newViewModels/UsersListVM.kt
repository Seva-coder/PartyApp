package ru.sevastianov.wb.ui.newViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.map
import ru.sevastianov.domain.newUseCases.IGetEventUsers
import ru.sevastianov.wb.Domain2Ui


internal class UsersListVM(getEventUsers: IGetEventUsers, val converter: Domain2Ui) : ViewModel() {

    private val usersListFlow = getEventUsers.execute().map { list ->
        list.map { converter.user2UI(it) }
    }

    fun getUsersList() = usersListFlow

}