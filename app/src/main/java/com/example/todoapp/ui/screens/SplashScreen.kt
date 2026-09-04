package com.example.todoapp.ui.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.todoapp.MainActivity
import com.example.todoapp.R
import com.example.todoapp.ui.screens.ui.theme.ToDoAppTheme
import com.example.todoapp.ui.theme.Grey
import com.example.todoapp.ui.theme.premiumGrey
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Old Method
//        Handler(Looper.getMainLooper()).postDelayed(
//            {
//                startActivity(Intent(this, MainActivity::class.java))
//                finish()
//        }, 2500
//        )

        //New Method
        lifecycleScope.launch {
            delay(2500.milliseconds)
            startActivity(
                Intent(
                    this@SplashScreen,
                    MainActivity::class.java
                )
            )
            finish()
        }

        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.Center)
                                .offset(y = (-30).dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.new_icon2),
                                contentDescription = "Logo",
                                modifier = Modifier.size(225.dp)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Text(
                                text = "TaskFlow",
                                fontSize = 45.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = premiumGrey
                            )

                            Spacer(modifier = Modifier.height(1.dp))

                            Text(
                                text = "Keep Your Day on Track",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                color = Grey
                            )
                        }


                        Text(
                            text = "Developed by Abhay",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Grey,
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 40.dp)
                        )
                    }
                }

            }
        }
    }

}
