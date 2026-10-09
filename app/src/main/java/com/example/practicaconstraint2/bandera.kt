
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
fun BanderaSudafrica(modifier: Modifier = Modifier) {
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

            drawRect(Color(0xFFDE3831))
            drawRect(Color(0xFF002395), Offset(0f, h * 0.5f),
                androidx.compose.ui.geometry.Size(w, h * 0.5f))

            fun polygon(color: Color, points: List<Offset>) {
                val p = Path().apply {
                    moveTo(points[0].x, points[0].y)
                    points.drop(1).forEach { lineTo(it.x, it.y) }
                    close()
                }
                drawPath(p, color)
            }

            polygon(Color(0xFFFFB81C), listOf(
                Offset(0f, 0f), Offset(w * 0.46f, h * 0.5f),
                Offset(0f, h)
            ))
            polygon(Color.White, listOf(
                Offset(0f, h * 0.10f), Offset(w * 0.38f, h * 0.5f),
                Offset(0f, h * 0.90f)
            ))
            polygon(Color(0xFF007A4D), listOf(
                Offset(0f, h * 0.23f), Offset(w * 0.28f, h * 0.5f),
                Offset(0f, h * 0.77f)
            ))
            polygon(Color(0xFFFFB81C), listOf(
                Offset(0f, h * 0.29f), Offset(w * 0.22f, h * 0.5f),
                Offset(0f, h * 0.71f)
            ))
            polygon(Color.Black, listOf(
                Offset(0f, h * 0.35f), Offset(w * 0.15f, h * 0.5f),
                Offset(0f, h * 0.65f)
            ))

            // Brazos de la Y
            polygon(Color.White, listOf(
                Offset(w * 0.22f, 0f), Offset(w * 0.34f, 0f),
                Offset(w * 0.66f, h * 0.38f), Offset(w, h * 0.38f),
                Offset(w, h * 0.62f), Offset(w * 0.66f, h * 0.62f),
                Offset(w * 0.34f, h), Offset(w * 0.22f, h),
                Offset(w * 0.55f, h * 0.55f), Offset(w, h * 0.55f),
                Offset(w, h * 0.45f), Offset(w * 0.55f, h * 0.45f)
            ))
            polygon(Color(0xFF007A4D), listOf(
                Offset(w * 0.29f, 0f), Offset(w * 0.39f, 0f),
                Offset(w * 0.70f, h * 0.40f), Offset(w, h * 0.40f),
                Offset(w, h * 0.60f), Offset(w * 0.70f, h * 0.60f),
                Offset(w * 0.39f, h), Offset(w * 0.29f, h),
                Offset(w * 0.62f, h * 0.55f), Offset(w, h * 0.55f),
                Offset(w, h * 0.45f), Offset(w * 0.62f, h * 0.45f)
            ))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSudafricaPreview() {
    BanderaSudafrica(Modifier.size(width = 360.dp, height = 220.dp))
}