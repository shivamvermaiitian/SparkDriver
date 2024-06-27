package com.example.sparkdriverloginpage.ui.theme

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateTestViewModel:ViewModel() {
    private val _name=MutableLiveData<String>()
    val name:LiveData<String> = _name

    fun onNameUpdate(newName:String){
        _name.value=newName
    }

    private val _password=MutableLiveData<String>()
    val password:LiveData<String> = _password
    fun onPasswordUpdate(newPassword:String){
        _password.value=newPassword
    }

    private val _isValid=MutableLiveData<Boolean>()
    val isValid : LiveData<Boolean> = _isValid
//    fun isValidUpdate(newisValid:Boolean){
//        _isValid.value=newisValid
//    }
    fun isValidCredentials(name: String) {
        _isValid.value= Patterns.EMAIL_ADDRESS.matcher(name).matches()
    }

    private val _isValidEmailPassword=MutableLiveData<Boolean>()
    val isValidEmailPassword : LiveData<Boolean> = _isValidEmailPassword
    fun isValidEmailPasswordCredentials(name: String, password: String) {
        val passwordPattern = Regex("^(?=.*[0–9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
        _isValidEmailPassword.value= Patterns.EMAIL_ADDRESS.matcher(name).matches() && passwordPattern.matches(password)
    }

    private val _passwordVisibility=MutableLiveData<Boolean>()
    val passwordVisibility:LiveData<Boolean> = _passwordVisibility
    fun passwordVisibilitychange(check:Boolean){
        _passwordVisibility.value=check
    }

}