package com.example.profilecompose

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
object Login
@Serializable
data class Profile(val name: String)
@Serializable
object Search
@Serializable
data class Detail(val name: String)
object NavRoutes{
    const val LOGIN = "Login"
    const val CHECK_ACCESS_WITH_ARGS = "check_access/{username}/{password}"
}