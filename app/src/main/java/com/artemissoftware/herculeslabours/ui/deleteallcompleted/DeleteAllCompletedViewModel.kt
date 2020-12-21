package com.artemissoftware.herculeslabours.ui.deleteallcompleted

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.artemissoftware.herculeslabours.data.TaskDao
import com.artemissoftware.herculeslabours.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DeleteAllCompletedViewModel @ViewModelInject constructor(private val taskDao: TaskDao,
                                                               @ApplicationScope private val applicationScope: CoroutineScope) : ViewModel(){

    fun onConfirmClick() = applicationScope.launch {
        taskDao.deleteCompletedTasks()
    }

}