package com.example.kotlinassignment.ui

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinassignment.domain.ToDoUseCase
import com.example.kotlinassignment.data.Todo
import kotlinx.coroutines.*
import java.net.UnknownHostException
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val toDoUseCase: ToDoUseCase) : ViewModel() {

    var todoData: MutableLiveData<List<Todo>> = MutableLiveData()
    var noInternetError: MutableLiveData<String> = MutableLiveData()
    var error: ObservableBoolean = ObservableBoolean()
    var showLoader: ObservableBoolean = ObservableBoolean(true)
    val exceptionHandler = CoroutineExceptionHandler { _, t ->
        showLoader.set(false)
        error.set(true)
        if(t is UnknownHostException){
           noInternetError.postValue( "No Internet Connection")
        }
    }

    val viewModelScope = CoroutineScope(Dispatchers.IO + SupervisorJob() + exceptionHandler)

    fun getTodoList() {
        showLoader.set(true)
        viewModelScope.launch(Dispatchers.IO) {
            val result = toDoUseCase.getTodoList()
            withContext(Dispatchers.Main) {
                showLoader.set(false)
                if (result.isNullOrEmpty()) {
                    error.set(true)
                } else {
                    error.set(false)
                    todoData.value = result
                }
            }
        }
    }

    fun onReloadClick() {
        error.set(false)
        getTodoList()
    }
}