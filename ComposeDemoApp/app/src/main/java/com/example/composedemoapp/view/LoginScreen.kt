package com.example.composedemoapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemoapp.R

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            login()
        }
    }

    private fun loginStatus(username: String, password: String) {
        if (username == "vikas" && password == "123") {
            Toast.makeText(this, "Logged In!!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Getting Error", Toast.LENGTH_SHORT).show()

        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun login() {
        val username = remember { mutableStateOf("") }
        val pass = remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = R.drawable.burger_hd),
                contentDescription = "burger",
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Login Here",
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = username.value,
                onValueChange = {
                    username.value = it
                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "person"
                    )
                },
                label = {
                    Text(text = "Username")
                },
                placeholder = {
                    Text(text = "Enter user name")
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = pass.value,
                onValueChange = {
                    pass.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Info, "password")
                },
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Enter Password")
                }
            )
            //spacer provides space between two view components
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedButton(
                onClick = {
                    loginStatus(username.value, pass.value)
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Login",
                    color = Color.Blue,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp
                )

            }

        }


    }
}

