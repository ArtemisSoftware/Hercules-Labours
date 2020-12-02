package com.artemissoftware.herculeslabours.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.artemissoftware.herculeslabours.data.TaskDao

class TasksViewModel @ViewModelInject constructor(private val taskDao: TaskDao) : ViewModel(){
}