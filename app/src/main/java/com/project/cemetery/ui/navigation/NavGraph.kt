package com.project.cemetery.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.cemetery.ui.PrintScreen
import com.project.cemetery.ui.SearchScreen
import com.project.cemetery.feature.grave.AddGraveScreen
import com.project.cemetery.feature.grave.gravelist.GraveListScreen
import com.project.cemetery.feature.map.MapScreen
import com.project.cemetery.ui.home.HomeScreen

@Composable
fun NavGraph(
    modifier: Modifier
) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("add") { AddGraveScreen() }
        composable("map") { MapScreen() }
        composable("search") { SearchScreen() }
        composable("print") { PrintScreen() }
        composable("list") { GraveListScreen() }
    }
}