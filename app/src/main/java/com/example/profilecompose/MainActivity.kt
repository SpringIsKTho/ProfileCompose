package com.example.profilecompose

import android.R.attr.content
import android.R.id.content
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecompose.ui.theme.ProfileComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationWrapper()
            /*Scaffold(
                modifier = Modifier.padding(14.dp)
                    .background(Color(R.color.background)),
                topBar = {
                    topBar()
                },
                content = {
                    app()
                }
            )*/
        }
    }
}


@Preview
@Composable
fun topBar(){
    LazyRow {
        item {
            Text(
                text = "App profile"
            )
        }
    }
}

@SuppressLint("ResourceAsColor")
@Preview
@Composable
fun app(){
    var counter_likes by rememberSaveable{ mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
        item{
            Image(
                modifier = Modifier.wrapContentSize(Alignment.Center),
                painter = painterResource(R.drawable.smiley),
                contentDescription = "Profile"
            )
            Text(
                text = "Smiley",
                color = Color(R.color.teal_200),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp)
                    .wrapContentSize(Alignment.Center)
            )
            LazyRow {
                item {
                    Image(
                        painterResource(R.drawable.outline_bookmark_heart_24),
                        contentDescription = "likes",
                        Modifier.clickable(true, onClick = {
                            counter_likes = counter_likes + 1
                        }
                        )
                    )
                    Text(
                        text = counter_likes.toString()
                    )
                }
            }
        }
    }
}