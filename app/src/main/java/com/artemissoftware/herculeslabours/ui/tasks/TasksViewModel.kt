package com.artemissoftware.herculeslabours.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.artemissoftware.herculeslabours.data.TaskDao

class TasksViewModel @ViewModelInject constructor(private val taskDao: TaskDao) : ViewModel(){


    val tasks = taskDao.getTasks().asLiveData()
}