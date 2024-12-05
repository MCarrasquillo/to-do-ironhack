package com.example.to_do

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.to_do.ui.screens.AddTaskScreen
import com.example.to_do.ui.screens.DetailScreen
import com.example.to_do.ui.screens.MainScreen
import com.example.to_do.ui.screens.ProfileScreen
import com.example.to_do.viewModel.ProfileViewModel
import com.example.to_do.viewModel.TaskViewModel

@Composable
fun ToDoApp() {
    val navController = rememberNavController()
    val taskViewModel: TaskViewModel = viewModel()
    val profileViewModel: ProfileViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") {
            MainScreen(navController, taskViewModel, profileViewModel)
        }
        composable("add_task") {
            AddTaskScreen(navController, taskViewModel)
        }
        composable("detail/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull()
            if (taskId != null) {
                DetailScreen(navController, taskViewModel, taskId)
            }
        }
        composable("profile") {
            ProfileScreen(navController, profileViewModel)
        }
    }
}