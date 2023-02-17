package com.example.dynamiccontentexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

//val nameList = mutableListOf("a", "b", "c", "d", "e")

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
//    //val greetingListState = remember { mutableStateListOf("John", "Ran", "Takeoff") }
//    val newNameStateContent = remember {
//        mutableStateOf("")
//    }

       val newNameStateContent = viewModel.textFieldState.observeAsState(initial = "")


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        GreetingMessage(newNameStateContent.value) { newName ->
            viewModel.onTextChanged(newName)
        }
//            TextField(
//                value = newNameStateContent.value,
//                onValueChange = viewModel::onTextChanged
//            )
        }
    }
}



@Composable
fun GreetingMessage(
    textFieldValue: String,
    textFieldUpdate: (String) -> Unit
) {

    TextField(
        value = textFieldValue,
        onValueChange = {
            Log.i("reza", "$it: ")
            textFieldUpdate(it)
        }
    )


    Button(onClick = {}) {
        Text(text = textFieldValue)
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.headlineMedium
    )
}