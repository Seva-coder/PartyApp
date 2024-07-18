package ru.sevastianov.wb.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class PhoneInputVM : ViewModel()  {

    init {
        Log.d("VM test", "PhoneInputVM STARTED")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("VM test", "PhoneInputVM ON CLEARED")
    }

    private var phoneNumber: String = ""

    fun phoneInputed(phone: String) {
        phoneNumber = phone
        Log.d("VM test", "PhoneInputVM number inputed")
    }

}