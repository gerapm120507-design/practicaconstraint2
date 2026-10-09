
package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun BanderaSeychelles(modifier: Modifier = Modifier) {
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

            val colores = listOf(
                Color(0xFF003F87),
                Color(0xFFFCD856),
                Color(0xFFD62828),
                Color.White,
                Color(0xFF007A3D)
            )

            val limites = listOf(
                listOf(0f to 0f, 0.22f to 0f, 0.0f to 1f),
                listOf(0.22f to 0f, 0.44f to 0f, 0.25f to 1f, 0f to 1f),
                listOf(0.44f to 0f, 0.66f to 0f, 0.5f to 1f, 0.25f to 1f),
                listOf(0.66f to 0f, 0.88f to 0f, 0.75f to 1f, 0.5f to 1f),
                listOf(0.88f to 0f, 1f to 0f, 1f to 1f, 0.75f to 1f)
            )

            limites.forEachIndexed { index, puntos ->
                val p = Path().apply {
                    puntos.forEachIndexed { i, punto ->
                        val x = punto.first * w
                        val y = punto.second * h
                        if (i == 0) moveTo(x, y) else lineTo(x, y)
                    }
                    close()
                }
                drawPath(p, colores[index])
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSeychellesPreview() {
    BanderaSeychelles(Modifier.size(width = 360.dp, height = 220.dp))
}