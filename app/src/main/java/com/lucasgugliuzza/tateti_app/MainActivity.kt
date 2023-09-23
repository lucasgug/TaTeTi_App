package com.lucasgugliuzza.tateti_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.lucasgugliuzza.tateti_app.Navigation.Navigation
import com.lucasgugliuzza.tateti_app.ui.theme.TaTeTi_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            TaTeTi_AppTheme {
               // val viewModel by viewModels<GameViewModel>()
                //GameScreen(viewModel)
                Navigation()
            }
        }
    }
}

