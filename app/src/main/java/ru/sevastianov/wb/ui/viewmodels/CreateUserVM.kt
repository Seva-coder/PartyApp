package ru.sevastianov.wb.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class CreateUserVM : ViewModel() {

    init {
        Log.d("VM test", "CreateUserVM STARTED")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("VM test", "CreateUserVM ON CLEARED")
    }

    fun createUser(name: String, surname: String) {
        Log.d("VM test", "create $name $surname")
    }

}