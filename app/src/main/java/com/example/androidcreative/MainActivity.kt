package com.example.androidcreative

import adddelete.AddDeleteScreen
import adddeletegrid.AddDeleteGridNavGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidcreative.ui.theme.AndroidCreativeTheme
import profilecard.ProfileCardScreen
import androidx.navigation.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddDeleteGridNavGraph()
        }
    }
}