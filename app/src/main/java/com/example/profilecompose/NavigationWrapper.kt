package com.example.profilecompose

import android.R.attr.name
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute


@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.LOGIN){

        composable(NavRoutes.LOGIN){
            LoginScreen(
                navigateToCheckAccess = {user, passwd ->
                    navController.navigate("check_access/$user/$passwd")
                }
            )
        }

        composable(
            route= NavRoutes.CHECK_ACCESS_WITH_ARGS,
            arguments = listOf(
                navArgument("username"){type = NavType.StringType},
                navArgument("password"){type = NavType.StringType},
            )
        ){
            backEntry ->
            val username = backEntry.arguments?.getString("username")
            val password = backEntry.arguments?.getString("password")

            LaunchedEffect(key1 = Unit) {
                if (username == "admin" && password == "admin"){
                    navController.navigate(Search){
                        popUpTo(NavRoutes.LOGIN){inclusive = false}
                    }
                }else{
                    navController.navigateUp()
                }
            }
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
                    navController.navigate(NavRoutes.LOGIN)
                },
                navToProfile = {
                    navController.popBackStack()
                }
            )
        }
    }
}