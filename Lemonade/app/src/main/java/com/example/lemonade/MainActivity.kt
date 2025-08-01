package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun GameTitle(){
    Box(
        modifier = Modifier.background(Color(247,236,82))
    )
    {
        Text(
            "Lemonade Game",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier= Modifier.fillMaxWidth()
                .fillMaxHeight(0.1f)
                .padding(top=25.dp)
        )
    }
}

@Composable
fun LemonadeApp(modifier: Modifier= Modifier){

    var result by remember { mutableIntStateOf(1) }
    var squeezeCount by remember {mutableIntStateOf(0)}
    var squeezeTarget by remember { mutableIntStateOf((2..4).random()) }



    val imageResource = when(result){
        1 ->  R.drawable.lemon_tree
        2 ->  R.drawable.lemon_squeeze
        3 ->  R.drawable.lemon_drink
        4 ->  R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    val stringResource = when(result){
        1 ->  R.string.lemon_tree
        2 ->  R.string.lemon
        3 ->  R.string.lemonade
        4 ->  R.string.empty_glass
        else -> R.string.lemon_tree
    }
    GameTitle()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Card {
            Image(
                painterResource(imageResource),
                contentDescription = result.toString(),
                Modifier
                    .size(300.dp)
                    .background(Color(190, 236, 210))
                    .clickable(
                        onClick = {
                            when (result) {
                                1 -> {
                                    result = 2
                                    squeezeCount = 0
                                    squeezeTarget = (2..4).random()
                                }

                                2 -> {

                                    squeezeCount++
                                    if (squeezeCount >= squeezeTarget)
                                        result = 3
                                }

                                3 -> result = 4
                                4 -> result = 1
                            }
                        }
                    )

            )
        }
        Spacer(modifier.height(50.dp))
        Text(
            text= if(result==2) {
                val remaining=squeezeTarget-squeezeCount
                stringResource(stringResource) + " \n\"$remaining\" "
            }
            else {
                stringResource(stringResource)
            },
            textAlign= TextAlign.Center,
            fontSize = 18.sp
        )
    }


}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp(modifier = Modifier)
    }
}