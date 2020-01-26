package com.zestworks.todomvikoin.create.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zestworks.todomvikoin.database.room.Todo
import com.zestworks.todomvikoin.R
import com.zestworks.todomvikoin.create.intent.TodoCreateActionType
import com.zestworks.todomvikoin.create.viewModel.AddTodoViewModel
import kotlinx.android.synthetic.main.fragment_add_todo.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class AddTodoFragment: Fragment() {

    private val addTodoViewModel: AddTodoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_notes.setOnClickListener {
            if(!(todo_text.text.isNullOrEmpty() || todo_text.text.isNullOrBlank())) {
                //add a note
                val todo: Todo = Todo(UUID.randomUUID().toString(),todo_text.text.toString(),false)
                addTodoViewModel.performIntent(TodoCreateActionType.AddTodo(todo))
                findNavController().navigateUp()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}