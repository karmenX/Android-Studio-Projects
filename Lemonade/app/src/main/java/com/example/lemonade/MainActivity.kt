package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp(modifier = Modifier)

                }
            }
        }
    }


@Composable
fun LemonadeApp(modifier: Modifier= Modifier){

    var result by remember { mutableStateOf(1) }
    var squeezeCount by remember {mutableStateOf(0)}
    var squeezeTarget by remember { mutableStateOf((2..4).random()) }



    var imageResource = when(result){
        1 ->  R.drawable.lemon_tree
        2 ->  R.drawable.lemon_squeeze
        3 ->  R.drawable.lemon_drink
        4 ->  R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    var stringResource = when(result){
        1 ->  R.string.lemon_tree
        2 ->  R.string.lemon
        3 ->  R.string.lemonade
        4 ->  R.string.empty_glass
        else -> R.string.lemon_tree
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Card() {
            Image(
                painterResource(imageResource),
                contentDescription = result.toString(),
                Modifier.background(Color(195,236,210)).size(300.dp)
            )
        }
        Spacer(modifier.height(50.dp))
        Button(onClick = {
            when(result){
                1 -> {
                    result=2
                    squeezeCount=0
                    squeezeTarget=(2..4).random()
                }
                2 -> {

                    squeezeCount++
                    if(squeezeCount>=squeezeTarget)
                        result=3
                }
                3 -> result=4
                4 -> result=1
            }
        }) { Text(
            text= if(result==2) {
                var remaining=squeezeTarget-squeezeCount
                stringResource(stringResource) + " \n\"$remaining\" "
            }
            else {
                stringResource(stringResource)
            },
            textAlign= TextAlign.Center
        )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp(modifier = Modifier)
    }
}