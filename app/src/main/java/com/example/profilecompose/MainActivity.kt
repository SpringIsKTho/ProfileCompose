package com.example.profilecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.profilecompose.ui.theme.ProfileComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            app()
        }
    }
}

@Preview
@Composable
fun app(){
    var counter_likes by remember { mutableStateOf(0) }

    LazyColumn {
        item{
            Image(
                painter = painterResource(R.drawable.smiley),
                contentDescription = "Profile"
            )
            Text(
                text = "Smiley"
            )
            LazyRow {
                item {
                    Image(
                        painterResource(R.drawable.outline_bookmark_heart_24),
                        contentDescription = "likes",
                        Modifier.clickable(true, onClick = {
                            counter_likes = counter_likes + 1
                        })
                    )
                    Text(
                        text = counter_likes.toString()
                    )
                }
            }
        }
    }
}