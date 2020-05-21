package com.davidmendozamartinez.mvvm.form.validation.sample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davidmendozamartinez.mvvm.form.validation.sample.Validation.*

class LoginViewModel : ViewModel() {

    private val emailValidations = arrayOf(NOT_EMPTY_FIELD, VALID_EMAIL)
    private val passwordValidations = arrayOf(NOT_EMPTY_FIELD, VALID_PASSWORD)

    private val _errorEmail = MutableLiveData<Int>()
    val errorEmail: LiveData<Int> get() = _errorEmail

    private val _errorPassword = MutableLiveData<Int>()
    val errorPassword: LiveData<Int> get() = _errorPassword

    fun onLoginButtonClicked(email: String, password: String) {
        if (isFormValid(email, password)) {
            login(email, password)
        }
    }

    private fun login(email: String, password: String) {
        Log.d(LoginViewModel::class.java.name, "Login request with $email & $password")
    }

    private fun isFormValid(email: String, password: String): Boolean {
        _errorEmail.value = emailValidations.firstOrNull { !it.isValid(email) }?.getErrorId()
        _errorPassword.value = passwordValidations.firstOrNull { !it.isValid(password) }?.getErrorId()
        return arrayOf(_errorEmail, _errorPassword).all { it.value == null }
    }
}