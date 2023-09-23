package com.lucasgugliuzza.tateti_app.ui.theme

sealed class UserAction{
    object PlayAgainButtonClicked : UserAction()

    data class BoardTapped(val cellNo:Int) :UserAction()
}
