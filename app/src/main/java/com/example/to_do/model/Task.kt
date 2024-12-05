package com.example.to_do.model

data class Task(
    val id: Int,
    val name: String,
    val description: String,
    val isCompleted: Boolean,
)