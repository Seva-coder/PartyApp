package ru.sevastianov.wb.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class SmsCodeVM : ViewModel() {


    init {
        Log.d("VM test", "SmsCodeVM STARTED")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("VM test", "SmsCodeVM ON CLEARED")
    }


    fun codeInputed(code: String) {
        Log.d("VM test", "sms inputed: $code")
    }

    fun resendCode() {
        Log.d("VM test", "sms resended")
    }

}