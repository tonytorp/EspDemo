package com.example.demosovellus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demosovellus.ui.theme.DemosovellusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EspControllerScreen()
        }
    }
}

@Composable
fun EspControllerScreen(){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text( text = "Hello, World!", fontSize = 40.sp )
        Button( onClick = { /* Do something! */ } ) {
            Text("Click me!")
        }
        Button( onClick = { /* Do something! */ } ) {
            Text("Click me!")
        }
        Button( onClick = { /* Do something! */ } ) {
            Text("Click me!")
        }
        Button( onClick = { /* Do something! */ } ) {
            Text("Click me!")
        }
        Button( onClick = { /* Do something! */ } ) {
            Text("Click me!")
        }
        Button( onClick = { /* Do something! */ } ) {
            Text("Click me!")
        }
    }
}















@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemosovellusTheme {
        Greeting("Android")
    }
}