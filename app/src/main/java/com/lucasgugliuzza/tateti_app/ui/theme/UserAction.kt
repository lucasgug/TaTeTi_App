package com.lucasgugliuzza.tateti_app.ui.theme

sealed class UserAction{
    object PlayAgainButtonClicked : UserAction()

    //accion cuandp el usuario toca una de las celdas
    data class BoardTapped(val cellNo:Int) :UserAction()
}
