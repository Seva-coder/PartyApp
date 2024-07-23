package ru.sevastianov.wb.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.sevastianov.wb.ui.viewmodels.CreateUserVM
import ru.sevastianov.wb.ui.viewmodels.EventDetailsVM
import ru.sevastianov.wb.ui.viewmodels.EventsVM
import ru.sevastianov.wb.ui.viewmodels.GroupDetailsVM
import ru.sevastianov.wb.ui.viewmodels.GroupsVM
import ru.sevastianov.wb.ui.viewmodels.MyEventsVM
import ru.sevastianov.wb.ui.viewmodels.PhoneInputVM
import ru.sevastianov.wb.ui.viewmodels.ProfileVM
import ru.sevastianov.wb.ui.viewmodels.SmsCodeVM


val appModule = module {

    viewModel<SmsCodeVM> { SmsCodeVM() }
    viewModel<PhoneInputVM> { PhoneInputVM() }
    viewModel<CreateUserVM> { CreateUserVM() }
    viewModel<EventDetailsVM> { EventDetailsVM(getEventDetails = get(), setGoToEvent = get()) }
    viewModel<EventsVM> { EventsVM(getAllEventsUseCase = get(), getActiveEventsUseCase = get()) }
    viewModel<GroupDetailsVM> { GroupDetailsVM(getGroupDescription = get(), getGroupEvents = get()) }
    viewModel<GroupsVM> { GroupsVM(getAllGroups = get()) }
    viewModel<MyEventsVM> { MyEventsVM(getLastEventsUseCase = get(), getPlannedEventsUseCase = get()) }
    viewModel<ProfileVM> { ProfileVM(getUserProfile = get()) }

}