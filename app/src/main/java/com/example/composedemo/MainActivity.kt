package com.example.composedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationScreen()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, widthDp = 200, heightDp = 500)
@Composable
private fun ShowPreview() {
    // SayHello(name = "This is my first compose project!!")
    // ImagePreview()
    // ButtonPreview("Click Me")
    // TextFieldPreview()
    /*Column() {
        ListViewItem(R.drawable.user,"Vikas Kumar","Android Developer")
        ListViewItem(R.drawable.user,"Vikas Kumar","Android Developer")
        ListViewItem(R.drawable.user,"Vikas Kumar","Android Developer")
        ListViewItem(R.drawable.user,"Vikas Kumar","Android Developer")
        ListViewItem(R.drawable.user,"Vikas Kumar","Android Developer")
    }*/

}

@Composable
private fun CircularImage() {
    Image(
        painter = painterResource(id = R.drawable.user),
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(80.dp)
            .clip(CircleShape)
            .border(2.dp,Color.Yellow, CircleShape),
        contentDescription = "dummy"
    )
}

@Composable
fun UseOfModifier() {
    Text(text = "Hello",
        color = Color.Blue,
        modifier = Modifier
            .clickable { }
            .background(Color.Blue)
            .size(200.dp)
            .border(4.dp, Color.Yellow)
            .clip(CircleShape)
            .background(Color.Cyan)
    )
}

@Composable
fun ListViewItem(imageId: Int, name: String, occupation: String, modifier: Modifier) {
    Row(modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "dummy",
            modifier.size(40.dp)
        )
        Column() {
            Text(
                text = name,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            Text(
                text = occupation,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Light,
                color = Color.Gray
            )

        }
    }

}

@Composable
fun BoxLayout() {
    Box(contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = R.drawable.heart), contentDescription = "dummy")
        Image(painter = painterResource(id = R.drawable.right_arrow), contentDescription = "dummy")
    }
}

@Composable
fun LayoutDemo() {
    //column composable is used to arrange the element vertically
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //box layout is just like frame layout i.e put elements one above one
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "dummy"
            )
            Image(
                painter = painterResource(id = R.drawable.right_arrow),
                contentDescription = "dummy"
            )
        }
        //row composable is used to arrange the elements horizontally
        Row(horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "dummy"
            )
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "dummy"
            )
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "dummy"
            )
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "dummy"
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputText() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(value = state.value,
        onValueChange = {
            state.value = it
            Log.d("data", it)
        },
        label = { Text(text = "Enter message") })

}

@Composable
fun ImagePreview() {
    Image(
        painter = painterResource(id = R.drawable.heart),
        contentDescription = "Dummy Image",
        colorFilter = ColorFilter.tint(Color.Blue),
        modifier = Modifier
            .width(20.dp)
            .height(20.dp),
        alignment = Alignment.Center

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TextFieldPreview() {
    TextField(
        value = "hello vikas",
        onValueChange = {},
        label = { Text(text = "Enter First Name") },
        placeholder = {}
    )

}

@Composable
fun SayHello(name: String) {
    Text(
        text = "Hi! $name",
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp,
        textAlign = TextAlign.Justify,
        color = Color.Blue,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun ButtonPreview(name: String) {
    Button(
        onClick = { },
        Modifier.background(Color.Blue),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Blue
        ),
        enabled = false
    ) {
        Text(
            text = "$name",
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            fontSize = 16.sp

        )
        Image(
            painter = painterResource(id = R.drawable.right_arrow),
            contentDescription = "Dummy",
            colorFilter = ColorFilter.tint(Color.White),
        )

    }
}
