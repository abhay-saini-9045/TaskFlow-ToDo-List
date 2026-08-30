package com.example.todoapp.repositary

import com.example.todoapp.data.room_database.TaskDao
import com.example.todoapp.data.room_database.TaskItem
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val dao: TaskDao) {

    fun getAllTasks(): Flow<List<TaskItem>> {
        return dao.getAllTasks()
    }

    suspend fun insert(task: TaskItem) = dao.insert(task)

    suspend fun update(task: TaskItem) = dao.update(task)

    suspend fun delete(task: TaskItem) = dao.delete(task)
}