package ru.sevastianov.wb.di

import android.util.Log
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.sevastianov.wb.Domain2Ui
import ru.sevastianov.wb.ui.newViewModels.EventDetailVM
import ru.sevastianov.wb.ui.newViewModels.EventsScreenVM
import ru.sevastianov.wb.ui.newViewModels.UsersListVM


val appModule = module {
    single<Domain2Ui> { Domain2Ui() }
    viewModel<EventsScreenVM> {
        EventsScreenVM(
            getBigEvents = get(),
            getNearestEvents = get(), updNearest = get(), getAllTags = get(), getAllEvents = get(),
            setEventTags = get(), getEventsByTags = get(), converter = get(),
            filterEventsByText = get(), getFiltredEvents = get(), interestsExist = get()
        )
    }

    viewModel<EventDetailVM> { (eventId: Long) ->
        Log.d("CREATE", "CREATE")
        EventDetailVM(
            eventId = eventId,
            converter = get(),
            getEventDetails = get(),
            setEventId = get(),
            getGroupDescr = get(),
            setEventSubscription = get(),
            getCurrentEventSubscription = get(),
            getSameEvents = get(),
            getEventUsers = get()
        )
    }

    viewModel<UsersListVM> { UsersListVM(getEventUsers = get(), converter = get()) }
}