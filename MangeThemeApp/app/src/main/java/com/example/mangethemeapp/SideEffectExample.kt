package com.example.mangethemeapp

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.input.key.Key
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception



@Composable
fun LaunchEffectComposable() {
    val counter = remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        Log.d("LaunchedEffectComposable", "Started.....")

        try {
            for (i in 0..10) {
                counter.value++
                delay(1000)
            }
        } catch (e: Exception) {
            Log.d("LaunchedEffectComposable", e.message.toString())
        }
    }

    var text = "Counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter has stopped"
    }
    Text(text = text)
}

@Composable
fun CoroutineScopeComposable() {
    val counter= remember {
        mutableStateOf(0)
    }
    var scope= rememberCoroutineScope()
    var text="Counter is running ${counter.value}"
    if (counter.value==10){
        text="Counter has stopped"
    }
    Column {
        Text(text = text)
        Button(onClick = {}) {
            LaunchedEffect(key1 = Unit){
                scope.launch{
                    Log.d("CoroutineScopeComposable","Started...")
                    try {
                        for (i in 0..10){
                            counter.value++
                            delay(1000)
                        }
                    }catch (e:Exception){
                        Log.d("CoroutineScopeComposable",e.message.toString())
                    }
                }
            }

            Text(text = "Start")
        }
    }
}

@Composable
fun RememberStateLaunchEffect(){
    var counter= remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Unit){
        delay(2000)
        counter.value=10
    }

    Counter(counter.value)
}

@Composable
fun Counter(value: Int) {
    val state= rememberUpdatedState(newValue = value)
    LaunchedEffect(key1 =Unit){
        delay(5000)
        Log.d("rememberUpdatedState",state.value.toString())
    }
    Text(text = value.toString())
}

fun A(){
    Log.d("function A","This is function A")
}
fun B(){Log.d("Function B","This is Function B")}

@Composable
fun app(){
    var state=remember{ mutableStateOf(::A) }
    Button(onClick = {
        state.value=::B
    }) {
           Text(text = "Change State")
    }

    LoadingScreen(state.value)
}

@Composable
fun LoadingScreen(onTimeOut: ()->Unit) {
    val currentOnTimeOut by rememberUpdatedState(onTimeOut)
    LaunchedEffect(true){
        delay(5000)
        currentOnTimeOut()
    }
}
