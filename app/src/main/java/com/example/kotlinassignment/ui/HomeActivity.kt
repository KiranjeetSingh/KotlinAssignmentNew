package com.example.kotlinassignment.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinassignment.TodoItmeAdapter
import com.example.kotlinassignment.data.Todo
import com.example.kotlinassignment.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var todoList = ArrayList<Todo>()
    var todoItmeAdapter: TodoItmeAdapter?=null
    lateinit var binding: ActivityMainBinding
    val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = homeViewModel
        binding.executePendingBindings()
        handleObservers()
        setAdapter()
        homeViewModel.getTodoList()
    }

    private fun handleObservers(){
        homeViewModel.todoData.observe(this, Observer {list->
           todoList.addAll(list)
            todoItmeAdapter?.notifyDataSetChanged()
        })

        homeViewModel.noInternetError.observe(this, Observer {messg->
            binding.tvErrorMsg.text = messg
        })

    }


    private fun setAdapter() {
        todoItmeAdapter = TodoItmeAdapter(
            this,
            todoList
        )
        binding.rv?.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
            adapter = todoItmeAdapter
        }
    }
}
