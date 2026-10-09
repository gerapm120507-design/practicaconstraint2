
package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun BanderaUSA(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (dibujo) = createRefs()

        Canvas(Modifier.constrainAs(dibujo) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }) {
            val ancho = size.width
            val alto = size.height
            val altoFranja = alto / 13f

            for (i in 0 until 13) {
                drawRect(
                    color = if (i % 2 == 0) Color(0xFFB22234) else Color.White,
                    topLeft = Offset(0f, i * altoFranja),
                    size = Size(ancho, altoFranja)
                )
            }

            drawRect(
                color = Color(0xFF3C3B6E),
                topLeft = Offset.Zero,
                size = Size(ancho * 0.4f, altoFranja * 7f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaUSAPreview() {
    Box(Modifier.size(width = 360.dp, height = 220.dp)) {
        BanderaUSA(Modifier.fillMaxSize())
    }
}