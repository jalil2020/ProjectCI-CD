package com.example.projectci_cd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectci_cd.ui.theme.ProjectCICDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectCICDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen() {
    var editText by remember {
        mutableStateOf("")
    }

    var text by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            value = editText,
            onValueChange = {
                editText = it
            },
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .border(1.dp, shape = RoundedCornerShape(24.dp), color = Color.Cyan)
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    innerTextField()
                }
            })


        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            text = text,
            fontSize = 24.sp
        )

        Button(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(top = 16.dp), onClick = {
            text = editText
        }) {
            Text(text = "Send")
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
    ProjectCICDTheme {
        Screen()
    }
}