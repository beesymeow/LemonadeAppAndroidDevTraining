package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme() {
                MakingLemonadeApp(

                )
            }

        }
    }
}

@Composable
fun LemonadeStepsWithButtonImageText(modifier: Modifier = Modifier){
    // Logic
    var step by remember { mutableStateOf(1) }
    if (step > 4){
        step = 1
    }

    val imageResource = when (step){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> {R.drawable.lemon_restart}
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {step++}) {
            Image(
                painter = painterResource(R.drawable.lemon_tree),
                contentDescription = stringResource(R.string.content_desc_lemon_tree)
            )
        }
        Spacer(modifier = Modifier.height(34.dp))
        Text(stringResource(R.string.step_one), modifier = Modifier)
    }
}

@Preview
@Composable
fun MakingLemonadeApp(){
    LemonadeStepsWithButtonImageText(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}