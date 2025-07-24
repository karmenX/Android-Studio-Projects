package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                ComposeArticleTheme {
                    Surface(
                        color = MaterialTheme.colorScheme.background,
                        modifier = Modifier.fillMaxSize()
                    ){
                    ArticleApp()
                    }
                }

        }
    }
}

@Composable
fun ArticleApp(){
    Article(
        title= stringResource(R.string.title_text),
        first = stringResource(R.string.first_paragraph),
        second = stringResource(R.string.second_paragraph),
        backPicture = painterResource(R.drawable.picture)
    )
}

@Composable
private fun Article(title: String, first: String, second: String, backPicture: Painter){
    Column(modifier=Modifier) {
        Image(painter=backPicture, contentDescription = null)
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp,
        )
        Text(
            text = first,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
        )
        Text(
            text = second,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PagePreview(){
    ComposeArticleTheme {
        ArticleApp()
    }
}