package com.example.kotlinassignment.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinassignment.UserItmeAdapter
import com.example.kotlinassignment.data.User
import com.example.kotlinassignment.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var userList = ArrayList<User>()
    var userItmeAdapter: UserItmeAdapter?=null
    lateinit var binding: ActivityMainBinding
    val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
    }
    // Lateinit var null check

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = homeViewModel
        binding.executePendingBindings()
        handleObservers()
        setAdapter()
        homeViewModel.getUserList()
    }

    private fun handleObservers(){
        homeViewModel.userData.observe(this, Observer {list->
            userList.addAll(list)
            userItmeAdapter?.notifyDataSetChanged()
        })

        homeViewModel.noInternetError.observe(this, Observer {messg->
            binding.tvErrorMsg.text = messg

            messg.toast()
        })



    }


    private fun setAdapter() {
        userItmeAdapter = UserItmeAdapter(
            this,
            userList
        )
        binding.rv?.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = userItmeAdapter
        }
    }

    fun String.toast(){
        Toast.makeText(this@HomeActivity,this,Toast.LENGTH_SHORT).show()
    }
}
