package com.example.demornlibapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.library.RNLibActivity
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                LaunchButton()
            }
        }
        val intent = Intent(this, RNLibActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun LaunchButton() {
    val context = LocalContext.current
    Button(onClick = {
        // Start the RNLibActivity from your AAR
        context.startActivity(Intent(context, RNLibActivity::class.java))
    }) {
        Text("Launch React Native Activity")
    }
}