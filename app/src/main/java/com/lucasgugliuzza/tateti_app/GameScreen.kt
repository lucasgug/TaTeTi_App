package com.lucasgugliuzza.tateti_app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasgugliuzza.tateti_app.ui.theme.BlueCustom
import com.lucasgugliuzza.tateti_app.ui.theme.BoardBase
import com.lucasgugliuzza.tateti_app.ui.theme.Circle
import com.lucasgugliuzza.tateti_app.ui.theme.Cross
import com.lucasgugliuzza.tateti_app.ui.theme.GrayBackground
import com.lucasgugliuzza.tateti_app.ui.theme.UserAction
import com.lucasgugliuzza.tateti_app.state.BoardCellValue
import com.lucasgugliuzza.tateti_app.state.GameState
import com.lucasgugliuzza.tateti_app.state.VictoryType
import com.lucasgugliuzza.tateti_app.ui.theme.WinHorizontalLine1
import com.lucasgugliuzza.tateti_app.ui.theme.WinHorizontalLine2
import com.lucasgugliuzza.tateti_app.ui.theme.WinHorizontalLine3
import com.lucasgugliuzza.tateti_app.ui.theme.WinVDiagonallLine1
import com.lucasgugliuzza.tateti_app.ui.theme.WinVDiagonallLine2
import com.lucasgugliuzza.tateti_app.ui.theme.WinVerticallLine1
import com.lucasgugliuzza.tateti_app.ui.theme.WinVerticallLine2
import com.lucasgugliuzza.tateti_app.ui.theme.WinVerticallLine3
import com.lucasgugliuzza.tateti_app.viewModel.GameViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GameScreen(
    viewModel: GameViewModel
) {


    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBackground)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Player 'O' : ${state.playerCircleCount} ", fontSize = 16.sp)
            Text(text = "Draw  : ${state.drawCount} ", fontSize = 16.sp)
            Text(text = "Player 'X' : ${state.playerCrossCount} ", fontSize = 16.sp)
        }
        Text(text = "Tic Tac Toe",
            fontWeight = FontWeight.Bold,
            color = BlueCustom,
            style = TextStyle(
                fontSize = 50.sp,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(7f,11f),
                    blurRadius = 6f
                )
            )
        )

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(GrayBackground),
            contentAlignment = Alignment.Center
        ){
            BoardBase()
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3)

            ){
                viewModel.boardItems.forEach { (cellNo, boardCellValue ) ->
                    item {

                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .clickable(
                                interactionSource = MutableInteractionSource(), //eliminamos los efectos al seleccionar una casilla
                                indication = null
                            ) {
                                viewModel.onAction(UserAction.BoardTapped(cellNo))
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        AnimatedVisibility(
                            visible =   viewModel.boardItems[cellNo] != BoardCellValue.NONE,
                            enter = scaleIn(tween(1000))
                        ) {
                            if (boardCellValue == BoardCellValue.CIRCLE){
                                Circle()
                            }else if(boardCellValue == BoardCellValue.CROSS)  {
                                Cross()
                            }
                        }
                    }

                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(
                    visible = state.hasWon,
                    enter = fadeIn(tween(2000))
                ) {
                    DrawVictoryLine(state = state)
                }
            }
        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment =Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = state.hintText,
                fontSize = 24.sp,
            )
            Button(
                onClick = { viewModel.onAction(UserAction.PlayAgainButtonClicked) },
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = BlueCustom
                )

            ) {
                Text(text = "Play Again" , fontSize = 16.sp)
            }
        }


    }
}

@Composable
fun DrawVictoryLine(
    state : GameState
) {
    when(state.victoryType){
        VictoryType.HORIZONTALLINE1 -> WinHorizontalLine1()
        VictoryType.HORIZONTALLINE2 -> WinHorizontalLine2()
        VictoryType.HORIZONTALLINE3 -> WinHorizontalLine3()
        VictoryType.VERTICALLINE1 -> WinVerticallLine1()
        VictoryType.VERTICALLINE2 -> WinVerticallLine2()
        VictoryType.VERTICALLINE3 -> WinVerticallLine3()
        VictoryType.DIAGONALLINE1 -> WinVDiagonallLine1()
        VictoryType.DIAGONALLINE2 -> WinVDiagonallLine2()
        VictoryType.NONE -> {}
    }
    
}


@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    //GameScreen()

}