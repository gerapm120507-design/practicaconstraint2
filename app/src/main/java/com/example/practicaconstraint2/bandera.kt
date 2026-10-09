
package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun BanderaReinoUnido(modifier: Modifier = Modifier) {
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
            drawRect(Color(0xFF012169))

            fun poligono(color: Color, puntos: List<Offset>) {
                val p = Path().apply {
                    moveTo(puntos[0].x, puntos[0].y)
                    puntos.drop(1).forEach { lineTo(it.x, it.y) }
                    close()
                }
                drawPath(p, color)
            }

            poligono(Color.White, listOf(
                Offset(0f, 0f), Offset(w * 0.12f, 0f),
                Offset(w, h * 0.88f), Offset(w, h),
                Offset(w * 0.88f, h), Offset(0f, h * 0.12f)
            ))
            poligono(Color.White, listOf(
                Offset(w, 0f), Offset(w, h * 0.12f),
                Offset(w * 0.12f, h), Offset(0f, h),
                Offset(0f, h * 0.88f), Offset(w * 0.88f, 0f)
            ))

            poligono(Color(0xFFC8102E), listOf(
                Offset(0f, 0f), Offset(w * 0.055f, 0f),
                Offset(w, h * 0.945f), Offset(w, h),
                Offset(w * 0.945f, h), Offset(0f, h * 0.055f)
            ))
            poligono(Color(0xFFC8102E), listOf(
                Offset(w, 0f), Offset(w, h * 0.055f),
                Offset(w * 0.055f, h), Offset(0f, h),
                Offset(0f, h * 0.945f), Offset(w * 0.945f, 0f)
            ))

            drawRect(Color.White, Offset(w * 0.40f, 0f),
                Size(w * 0.20f, h))
            drawRect(Color.White, Offset(0f, h * 0.35f),
                Size(w, h * 0.30f))

            drawRect(Color(0xFFC8102E), Offset(w * 0.455f, 0f),
                Size(w * 0.09f, h))
            drawRect(Color(0xFFC8102E), Offset(0f, h * 0.425f),
                Size(w, h * 0.15f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaReinoUnidoPreview() {
    BanderaReinoUnido(Modifier.size(width = 360.dp, height = 220.dp))
}