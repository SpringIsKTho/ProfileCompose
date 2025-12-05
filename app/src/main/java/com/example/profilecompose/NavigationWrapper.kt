package com.example.profilecompose

import android.R.attr.name
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute


@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login){
        composable<Login>{
            LoginScreen { username -> navController.navigate(Profile(name = username))}
        }
        composable<Search>{
            SearchScreen{name -> navController.navigate(Profile(name = name))}
        }
        composable<Profile>{
            backStackEntry ->
            val args = backStackEntry.toRoute<Profile>()
            ProfileScreen(name = args.name, navigateToDetail =  {
                navController.navigate(Detail(args.name))
            }, navigateToSearch = {
                navController.navigate(Search)
            })
        }

        composable<Detail>{ backStackEntry ->
            val args = backStackEntry.toRoute<Detail>()
            DetailScreen(
                name = args.name, navToLogin = {
                    navController.navigate(Login)
                },
                navToProfile = {
                    navController.popBackStack()
                }
            )
        }
    }
}