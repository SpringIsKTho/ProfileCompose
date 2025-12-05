package com.example.profilecompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen(name: String, navToLogin: () -> Unit, navToProfile: () -> Unit){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Detalle de $name")
        Button(onClick = {
            navToProfile()
        }) {
            Text(text = "Volver al perfil")
        }
        Button(onClick = {
            navToLogin()
        }){
            Text(text = "De vuelta al Login")
        }
    }
}