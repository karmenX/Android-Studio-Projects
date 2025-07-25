package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                    Surface(
                        color = MaterialTheme.colorScheme.background
                    ){
                    TaskApp()}
            }
        }
    }
}
@Composable
fun TaskApp(){
    val image = painterResource(R.drawable.done)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = stringResource(R.string.task_completed_text),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top=24.dp, bottom = 8.dp),
        )
        Text(
            text = stringResource(R.string.nice_work_text),
            fontSize = 16.sp,
            modifier= Modifier.align(alignment = Alignment.CenterHorizontally)
        )
    }


}


@Preview(showBackground = true)
@Composable
fun TaskAppPreview(){
    TaskManagerTheme {
        TaskApp()
    }

}

