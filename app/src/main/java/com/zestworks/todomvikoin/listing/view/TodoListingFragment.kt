package com.zestworks.todomvikoin.listing.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.zestworks.todomvikoin.R
import com.zestworks.todomvikoin.listing.adapter.TodoListingAdapter
import com.zestworks.todomvikoin.listing.intent.TodoListingActionType
import com.zestworks.todomvikoin.listing.viewModel.TodoListingViewModel
import kotlinx.android.synthetic.main.fragment_todo_listing.*
import org.koin.android.viewmodel.ext.android.viewModel

class TodoListingFragment: Fragment() {

    lateinit var adapter: TodoListingAdapter
    private val todoListingViewModel: TodoListingViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_todo.setOnClickListener {
            findNavController().navigate(R.id.action_todoListingFragment_to_addTodoFragment)
        }
        adapter = TodoListingAdapter(listOf(),object : TodoListingAdapter.AdapterListener {
            override fun onDoneToggled(id: String, done: Boolean) {
                todoListingViewModel.performIntent(TodoListingActionType.UpdateTodoStatus(id, done))
            }

            override fun onDelete(id: String) {
                todoListingViewModel.performIntent(TodoListingActionType.DeleteTodo(id))
            }

        })
        todo_list.adapter = adapter
        todo_list.layoutManager = LinearLayoutManager(context)
    }

    override fun onStart() {
        super.onStart()
        todoListingViewModel.todoListData.observe(this, Observer {
            adapter.updateData(it)
        })
    }

}