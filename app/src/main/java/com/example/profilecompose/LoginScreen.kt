package com.example.profilecompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.w3c.dom.Text

@Composable
fun LoginScreen(navigateToCheckAccess: (user: String, passwd: String) -> Unit){
    var error by remember {mutableStateOf(false)}
    var user by remember {mutableStateOf("")}
    var passwd by remember { mutableStateOf("")}
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Login screen", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        if (error == true){
            Text("Usuario o contraseña incorrectos", color = MaterialTheme.colorScheme.error)
        }
        TextField(value = user, onValueChange = {user = it}, placeholder = {Text("usuario")})
        TextField(value = passwd, onValueChange = {passwd = it}, placeholder = {Text("contraseña")})

        Button(onClick = {
            navigateToCheckAccess(user, passwd)
        }) {
            Text("Login")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}