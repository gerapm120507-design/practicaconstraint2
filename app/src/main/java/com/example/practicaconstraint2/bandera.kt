
package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun BanderaGuinea(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier) {
        val (dibujo) = createRefs()

        Canvas(Modifier.constrainAs(dibujo) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }) {
            val w = size.width
            val h = size.height

            val rojo = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, 0f)
                lineTo(0f, h)
                close()
            }
            drawPath(rojo, Color(0xFFCC0000))

            val negro = Path().apply {
                moveTo(w, 0f)
                lineTo(w, h)
                lineTo(0f, h)
                close()
            }
            drawPath(negro, Color.Black)

            // Ave estilizada
            val ave = Path().apply {
                moveTo(w * 0.30f, h * 0.10f)
                lineTo(w * 0.55f, h * 0.23f)
                lineTo(w * 0.83f, h * 0.14f)
                lineTo(w * 0.69f, h * 0.35f)
                lineTo(w * 0.78f, h * 0.50f)
                lineTo(w * 0.58f, h * 0.46f)
                lineTo(w * 0.48f, h * 0.75f)
                lineTo(w * 0.40f, h * 0.48f)
                lineTo(w * 0.20f, h * 0.55f)
                lineTo(w * 0.31f, h * 0.36f)
                close()
            }
            drawPath(ave, Color(0xFFFFD700))

            val estrellas = listOf(
                0.72f to 0.70f,
                0.82f to 0.79f,
                0.67f to 0.88f,
                0.88f to 0.93f,
                0.54f to 0.91f
            )
            estrellas.forEach { (x, y) ->
                drawCircle(Color.White, w * 0.018f, Offset(w * x, h * y))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaGuineaPreview() {
    BanderaGuinea(Modifier.size(width = 360.dp, height = 220.dp))
}