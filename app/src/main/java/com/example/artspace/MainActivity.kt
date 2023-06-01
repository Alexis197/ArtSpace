package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.example.artspace.ui.theme.ArtSpaceTheme

import androidx.compose.material3.Button



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}


@Composable
fun ArtSpace(modifier: Modifier = Modifier,){
    var index by remember { mutableStateOf(0) }
    val images = listOf(R.drawable.dragon1, R.drawable.dragon6, R.drawable.dragon7, R.drawable.dragon8, R.drawable.dragon9)
    val names = listOf(R.string.nombrePintura1,R.string.nombrePintura2,R.string.nombrePintura3,R.string.nombrePintura4,R.string.nombrePintura5)
    val autor = listOf(R.string.autor1,R.string.autor2,R.string.autor3,R.string.autor4,R.string.autor5)
    //
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = images[index]), contentDescription = null)
        Text(text = stringResource(id = names[index]))
        Text(text = stringResource(id = autor[index]))
        Spacer(
            modifier = Modifier.height((16.dp))
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    if (index == 0) {
                        index = (4)
                    } else {
                        index = (index - 1)
                    }
                },
                modifier = Modifier.size(120.dp, 40.dp),
            ) {
                Text(stringResource(R.string.preview)) }
            Button(
                onClick = {
                    if (index==4){
                        index = (0)
                    }else{
                        index = (index + 1)
                    }
                },
                modifier = Modifier.size(120.dp, 40.dp)
            ) { Text(stringResource(R.string.next)) }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}