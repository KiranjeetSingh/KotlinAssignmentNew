package com.example.kotlinassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinassignment.data.User
import com.example.kotlinassignment.databinding.ItemUserBinding

 class UserItmeAdapter(var context: Context, var list: ArrayList<User>): RecyclerView.Adapter<UserItmeAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.setVariable(BR.user, user)
            binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:ItemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_user, parent, false)
        return ViewHolder(binding)}

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

}