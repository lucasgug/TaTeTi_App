package com.lucasgugliuzza.tateti_app.splashscreen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucasgugliuzza.tateti_app.R

@Composable
fun SplashScreen() {
    val listColors = listOf(Color.Black, Color.Blue, Color.Magenta )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(listColors)
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Card (
            shape = RoundedCornerShape(180.dp),
            modifier = Modifier.size(340.dp),


        ) {
            Image(
                painter = painterResource(id = R.drawable.tic_tac_toe)  ,
                contentDescription = "logo",
                modifier = Modifier.fillMaxSize()

            )
        }

    }

}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}