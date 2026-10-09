
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
fun BanderaNepal(modifier: Modifier = Modifier) {
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

            fun triangle(points: List<Offset>, color: Color) {
                val p = Path().apply {
                    moveTo(points[0].x, points[0].y)
                    points.drop(1).forEach { lineTo(it.x, it.y) }
                    close()
                }
                drawPath(p, color)
            }

            triangle(listOf(
                Offset(w * 0.12f, h * 0.05f),
                Offset(w * 0.75f, h * 0.55f),
                Offset(w * 0.12f, h * 0.55f),
                Offset(w * 0.12f, h * 0.05f)
            ), Color(0xFF003893))

            triangle(listOf(
                Offset(w * 0.12f, h * 0.40f),
                Offset(w * 0.86f, h * 0.92f),
                Offset(w * 0.12f, h * 0.92f),
                Offset(w * 0.12f, h * 0.40f)
            ), Color(0xFF003893))

            triangle(listOf(
                Offset(w * 0.15f, h * 0.10f),
                Offset(w * 0.68f, h * 0.50f),
                Offset(w * 0.15f, h * 0.50f),
                Offset(w * 0.15f, h * 0.10f)
            ), Color(0xFFDC143C))

            triangle(listOf(
                Offset(w * 0.15f, h * 0.45f),
                Offset(w * 0.78f, h * 0.87f),
                Offset(w * 0.15f, h * 0.87f),
                Offset(w * 0.15f, h * 0.45f)
            ), Color(0xFFDC143C))

            drawCircle(
                Color.White, w * 0.045f,
                Offset(w * 0.30f, h * 0.37f)
            )
            drawCircle(
                Color.White, w * 0.06f,
                Offset(w * 0.32f, h * 0.70f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaNepalPreview() {
    BanderaNepal(Modifier.size(width = 300.dp, height = 360.dp))
}