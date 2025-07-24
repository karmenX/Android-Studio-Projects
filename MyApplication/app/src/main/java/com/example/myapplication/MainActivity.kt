package com.example.myapplication

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                MyApplicationTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.White
                    ){
                        GreetingImage(message = stringResource(R.string.happy_birthday_text), from = stringResource(
                            R.string.signature_text
                        )
                        )
                    }
                }
            }
        }
    }

@Composable
fun GreetingText(message: String, modifier: Modifier = Modifier, from: String) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        )

        {
            Text(
                text = message,
                textAlign = TextAlign.Center,
                fontSize = 75.sp,//sp: scalable pixels
                lineHeight = 116.sp
            )
            Text(
                text = from,
                fontSize = 36.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally) //dp: density independent
            )

        }
    }

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){//Modifiers tell a UI element how to lay out, display, or behave within its parent layout.
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,//so that TalkBack skips the image composable
            contentScale = ContentScale.Crop,
//parameter scaling, which scales the image uniformly to maintain the aspect ratio so that the width and height of the
// image are equal to, or larger than, the corresponding dimension of the screen.
            alpha = 0.5F,//Opacity: original is 1,transparent is 0
        )
        GreetingText(message=message,from=from, modifier = Modifier
            .fillMaxSize()
            .padding(8.dp))
    }
}



@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview(){
    MyApplicationTheme {
        GreetingImage(message = stringResource(R.string.happy_birthday_text), from = stringResource(R.string.signature_text))

    }
}