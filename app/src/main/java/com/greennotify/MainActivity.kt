package com.greennotify
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(Modifier.padding(20.dp)) {
                    Text("GreenNotify - Bangkok", style = MaterialTheme.typography.headlineMedium)
                    Text("33 Courses - 594 Greens loaded")
                    Text("Select course to start round. Notifications will appear as new message.")
                    Button(onClick = {}) { Text("Start Round - Alpine Golf Club Hole 1") }
                }
            }
        }
    }
}
