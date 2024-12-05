package com.example.to_do.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.to_do.model.Task

class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<MutableList<Task>>(mutableListOf())

    val tasks: LiveData<MutableList<Task>> = _tasks

    private var nextId = 1

    fun addTask(name: String, description: String) {
        val newTask = Task(
            id = nextId++,
            name = name,
            description = description,
            isCompleted = false
        )

        _tasks.value?.add(newTask)
        _tasks.value = _tasks.value
    }

    fun updateTask(updatedTask: Task) {
        _tasks.value = _tasks.value?.map { task ->
            if (task.id == updatedTask.id) updatedTask else task
        }?.toMutableList()
    }

    fun deleteTask(id: Int){
        _tasks.value = _tasks.value?.filter { it.id != id }?.toMutableList()
    }

    fun getTaskById(id: Int): Task? {
        return _tasks.value?.find {it.id == id}
    }
}