package com.lucasgugliuzza.tateti_app.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoardBase() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
           // .padding(10.dp)

    ){
//        drawLine(
//            color = Color.Gray,
//            strokeWidth = 5f, //grosor de la linea
//            cap = StrokeCap.Round, //redondea la linea la pricipio y al final
//            start = Offset(x= 0f , y = 0f),
//            end = Offset(x = 0f , y = size.height)
//        )
//        drawLine(
//            color = Color.Gray,
//            strokeWidth = 5f, //grosor de la linea
//            cap = StrokeCap.Round, //redondea la linea la pricipio y al final
//            start = Offset(x= 0f , y = 0f),
//            end = Offset(x = size.width , y = 0f)
//        )
//        drawLine(
//            color = Color.Gray,
//            strokeWidth = 5f, //grosor de la linea
//            cap = StrokeCap.Round, //redondea la linea la pricipio y al final
//            start = Offset(x= size.width , y = 0f),
//            end = Offset(x = size.width , y = size.height)
//        )
//        drawLine(
//            color = Color.Gray,
//            strokeWidth = 5f, //grosor de la linea
//            cap = StrokeCap.Round, //redondea la linea la pricipio y al final
//            start = Offset(x= 0f , y = size.height),
//            end = Offset(x = size.width , y = size.height)
//        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f, //grosor de la linea
            cap = StrokeCap.Round, //redondea la linea la pricipio y al final
            start = Offset(x= size.width * 2/6 , y = 0f),
            end = Offset(x = size.width *2/6 , y =size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f, //grosor de la linea
            cap = StrokeCap.Round, //redondea la linea la pricipio y al final
            start = Offset(x= size.width * 4/6 , y = 0f),
            end = Offset(x = size.width *4/6 , y =size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f, //grosor de la linea
            cap = StrokeCap.Round, //redondea la linea la pricipio y al final
            start = Offset(x= 0f , y = size.height * 2/6),
            end = Offset(x = size.width , y = size.height *2/6)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f, //grosor de la linea
            cap = StrokeCap.Round, //redondea la linea la pricipio y al final
            start = Offset(x= 0f , y = size.height * 4/6),
            end = Offset(x = size.width , y = size.height *4/6)
        )
    }
    
}


@Composable
fun Cross() {
        Canvas(
            modifier = Modifier
                .size(60.dp)
                .padding(5.dp)
        ){
            drawLine(
                color = Aqua ,
                strokeWidth = 20f, //grosor de la linea
                cap = StrokeCap.Round, //redondea la linea la pricipio y al final
                start = Offset(x= 0f , y = 0f ),
                end = Offset(x = size.width , y = size.height )
            )
            drawLine(
                color = Aqua ,
                strokeWidth = 20f, //grosor de la linea
                cap = StrokeCap.Round, //redondea la linea la pricipio y al final
                start = Offset(x= 0f, y = size.height ),
                end = Offset(x = size.width , y = 0f )
            )
        }
}

@Composable
fun Circle() {
    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)

    ){
        drawCircle(
            color = GreenCircle,
            style = Stroke(width = 20f)


        )
    }
}

@Composable
fun WinHorizontalLine1() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(bottom = 55.dp)

    ){
        drawLine(
            color = Color.Red,
            strokeWidth =  10f ,
            cap = StrokeCap.Round,
            start = Offset(x = 0f , y = size.height * 1/6   ),
            end = Offset(x = size.width, y= size.height * 1/6   ),
        )
    }
}

@Composable
fun WinHorizontalLine2() {
    Canvas(
        modifier = Modifier
            .size(300.dp)


    ){
        drawLine(
            color = Color.Red,
            strokeWidth =  10f ,
            cap = StrokeCap.Round,
            start = Offset(x = 0f , y = size.height * 3/6 )  ,
            end = Offset(x = size.width, y= size.height * 3/6  )  ,
        )
    }
}

@Composable
fun WinHorizontalLine3() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(top = 65.dp)


    ){
        drawLine(
            color = Color.Red,
            strokeWidth =  12f ,
            cap = StrokeCap.Round,
            start = Offset(x = 0f , y = size.height * 5/6   ),
            end = Offset(x = size.width, y= size.height * 5/6   ),
        )
    }
}

@Composable
fun WinVerticallLine1() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(end = 65.dp)



    ){
        drawLine(
            color = Color.Red,
            strokeWidth =  10f ,
            cap = StrokeCap.Round,
            start = Offset( x = size.width *1/6 , y = size.height   ),
            end = Offset( x = size.width *1/6 , y = 0f  ),
        )
    }
}

@Composable
fun WinVerticallLine2() {
    Canvas(
        modifier = Modifier
            .size(300.dp)

    ){
        drawLine(
            color = Color.Red,
            strokeWidth =  10f ,
            cap = StrokeCap.Round,
            start = Offset( x = size.width *3/6 , y = size.height   ),
            end = Offset( x = size.width *3/6 , y = 0f  ),
        )
    }
}


@Composable
fun WinVerticallLine3() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(start = 75.dp)

    ){
        drawLine(
            color = Color.Red,
            strokeWidth =  10f ,
            cap = StrokeCap.Round,
            start = Offset( x = size.width *5/6 , y = size.height   ),
            end = Offset( x = size.width *5/6 , y = 0f  ),
        )
    }
}

@Composable
fun WinVDiagonallLine2() {
    Canvas(
        modifier = Modifier
            .size(300.dp)

    ){
        drawLine(
            color = Color.Red,
            strokeWidth =  10f ,
            cap = StrokeCap.Round,
            start = Offset( x = 0f , y = size.height ),
            end = Offset( x = size.width , y = 0f  ),
        )
    }
}

@Composable
fun WinVDiagonallLine1() {
    Canvas(
        modifier = Modifier
            .size(300.dp)

    ){
        drawLine(
            color = Color.Red,
            strokeWidth =  10f ,
            cap = StrokeCap.Round,
            start = Offset( x = size.width  , y = size.height   ),
            end = Offset( x = 0f , y = 0f  ),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ComponentPreview() {
    BoardBase()
    WinHorizontalLine1()
    WinHorizontalLine2()
    WinHorizontalLine3()
    WinVerticallLine1()
    WinVerticallLine2()
    WinVerticallLine3()




}