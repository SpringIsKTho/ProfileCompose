package com.example.profilecompose

import android.R.attr.text
import android.icu.text.StringSearch
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.w3c.dom.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun SearchScreen(navitageToProfile: (String) -> Unit){
    var texto by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Buscador screen", fontSize = 20.sp)
        Spacer(modifier = Modifier.weight(1f))
        TextField(value = texto, onValueChange = {texto = it})
        Button(onClick = {
            navitageToProfile(texto)
        }) {
            Text("buscar perfil")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}