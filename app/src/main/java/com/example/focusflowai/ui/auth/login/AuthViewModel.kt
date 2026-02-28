package com.example.focusflowai.ui.auth.login

import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {


    fun login(email: String, password: String) : Boolean{
        return email.isNotEmpty() && password.isNotEmpty()
    }
    fun signup(name: String, email: String, password: String): Boolean {
        return name.isNotEmpty()
                && email.isNotEmpty()
                && password.isNotEmpty()
    }
}