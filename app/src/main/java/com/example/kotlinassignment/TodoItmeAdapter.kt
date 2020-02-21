package com.example.kotlinassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinassignment.data.Todo
import com.example.kotlinassignment.databinding.ItemTodoBinding

 class TodoItmeAdapter(var context: Context, var list: ArrayList<Todo>): RecyclerView.Adapter<TodoItmeAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.setVariable(BR.todo, todo)
            binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:ItemTodoBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_todo, parent, false)
        return ViewHolder(binding)}

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

}