package com.example.kotlinassignment.ui

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinassignment.BaseApplication
import com.example.kotlinassignment.data.Data
import com.example.kotlinassignment.domain.UserUseCase
import com.example.kotlinassignment.data.User
import kotlinx.coroutines.*
import java.net.UnknownHostException
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val userUseCase: UserUseCase) : AndroidViewModel(BaseApplication()) {

    val userData: MutableLiveData<List<User>> = MutableLiveData()
    val noInternetError: MutableLiveData<String> = MutableLiveData()
    val error: ObservableBoolean = ObservableBoolean()
    val showLoader: ObservableBoolean = ObservableBoolean(true)
    val exceptionHandler = CoroutineExceptionHandler { _, t ->
        showLoader.set(false)
        error.set(true)
        if(t is UnknownHostException){
           noInternetError.postValue( "No Internet Connection")
        }
    }

    val viewModelScope = CoroutineScope(Dispatchers.IO + SupervisorJob() + exceptionHandler)

    fun getUserList() {
        showLoader.set(true)
        viewModelScope.launch(Dispatchers.IO) {
            val result = userUseCase.getData()
            withContext(Dispatchers.Main) {
                showLoader.set(false)
                if (!result.isSuccessful()) {
                    error.set(true)
                } else {
                    error.set(false)
                    val response: Data? = result.body()
                    userData.postValue(response?.data)
                }
            }
        }
    }

    fun onReloadClick() {
        error.set(false)
        getUserList()
    }
}