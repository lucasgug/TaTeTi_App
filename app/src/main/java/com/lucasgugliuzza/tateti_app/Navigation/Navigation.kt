package com.lucasgugliuzza.tateti_app.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lucasgugliuzza.tateti_app.GameScreen
import com.lucasgugliuzza.tateti_app.splashscreen.SplashScreen
import com.lucasgugliuzza.tateti_app.viewModel.GameViewModel
import kotlinx.coroutines.delay

@Composable
fun Navigation() {

    val navController = rememberNavController()

   NavHost(navController = navController, startDestination = ScreenRoot.SplashScreen.route){
       composable(ScreenRoot.SplashScreen.route){

           SplashScreen()

          LaunchedEffect(key1 = null){
              delay(2000)
              navController.popBackStack() //permite no volver atras ,  de la home si apretamos para atras ,salimos de la aplicacion
              //directamente , si no ponemos esto al apretar para atras nos mostraria el splashscreen
              navController.navigate(ScreenRoot.GameScreen.route) //le paso la ruta de la siguiente pantalla
          }

       }

       composable(ScreenRoot.GameScreen.route){
           GameScreen(viewModel = GameViewModel())
       }
   }
}
sealed class ScreenRoot(val route : String ){
    object SplashScreen : ScreenRoot("splash")
    object GameScreen : ScreenRoot("home")
}