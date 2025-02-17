package com.example.demosovellus

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

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
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)) // Pyöristetyt kulmat
            .background(Color(0xFF64B5F6)) // Vaaleampi sininen väri
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Polhu",
            fontSize = 50.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun EspControllerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFEEEEEE)), // Vaaleanharmaa taustaväri
        horizontalAlignment = Alignment.CenterHorizontally // Keskitetään sisältö vaakasuunnassa
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Header()
        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(), // Vie kaiken jäljellä olevan tilan
            contentAlignment = Alignment.Center // Keskitetään sisältö
        ) {
            Button(
                onClick = { /* Do something! */ },
                modifier = Modifier.size(120.dp), // Asetetaan koko
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray) // Poistetaan pyöristetyt kulmat ja lisätään vaaleanharmaa tausta
            ) {
                Text("Vapautus")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween // Jakaa tilan tasaisesti
        ) {
            Button(
                onClick = { /* Do something! */ },
                modifier = Modifier.size(120.dp), // Asetetaan koko
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray) // Poistetaan pyöristetyt kulmat ja lisätään vaaleanharmaa tausta
            ) {
                Text("Eteen")
            }
            Button(
                onClick = { /* Do something! */ },
                modifier = Modifier.size(120.dp), // Asetetaan koko
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray) // Poistetaan pyöristetyt kulmat ja lisätään vaaleanharmaa tausta
            ) {
                Text("Taakse")
            }
        }

        Button(
            onClick = { /* Do something! */ },
            modifier = Modifier.size(120.dp), // Asetetaan koko
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray) // Poistetaan pyöristetyt kulmat ja lisätään vaaleanharmaa tausta
        ) {
            Text("Kuormitus")
        }
    }
}

fun sendRequestCoroutine(url: String) {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val connection = URL(url).openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            val responseCode = connection.responseCode
            val responseMessage = if (responseCode == 200) "Success" else "Error: $responseCode"

            connection.disconnect()
            Log.d("ESPController", "Response: $responseMessage")
        } catch (e: Exception) {
            Log.e("ESPController", "Request failed", e)
        }
    }
}







