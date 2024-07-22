package ru.sevastianov.repository

import android.content.Context
import ru.sevastianov.domain.repository.IEventsRepository

// internal - тогда koin не видит...
class EventsRepository(val context: Context) : IEventsRepository {



}