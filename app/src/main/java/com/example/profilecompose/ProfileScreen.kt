package com.example.profilecompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(name: String, navigateToDetail : () -> Unit, navigateToSearch: () -> Unit){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(0.2F))
        Text(text = "Perfil de $name", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {navigateToDetail()
        }) {
            Text("Show Details")
        }
        Button(onClick = {navigateToSearch()
        }) {
            Text("Back to Search")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}