
package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaTurquia(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.background(Color(0xFFE30A17))) {
        val (luna, estrella) = createRefs()

        Canvas(Modifier.constrainAs(luna) {
            start.linkTo(parent.start, margin = 55.dp)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            width = Dimension.percent(0.36f)
            height = Dimension.percent(0.58f)
        }) {
            val r = size.minDimension * 0.48f
            val c = Offset(size.width * 0.48f, size.height * 0.5f)
            drawCircle(Color.White, r, c)
            drawCircle(
                Color(0xFFE30A17), r * 0.80f,
                Offset(c.x + r * 0.40f, c.y - r * 0.12f)
            )
        }

        Canvas(Modifier.constrainAs(estrella) {
            start.linkTo(luna.end, margin = 4.dp)
            end.linkTo(parent.end, margin = 42.dp)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            width = Dimension.percent(0.19f)
            height = Dimension.percent(0.30f)
        }) {
            val cx = size.width / 2f
            val cy = size.height / 2f
            val outer = size.minDimension / 2f
            val inner = outer * 0.40f
            val p = Path()

            for (i in 0 until 10) {
                val a = Math.PI * i / 5 - Math.PI / 2
                val r = if (i % 2 == 0) outer else inner
                val x = cx + cos(a).toFloat() * r
                val y = cy + sin(a).toFloat() * r
                if (i == 0) p.moveTo(x, y) else p.lineTo(x, y)
            }
            p.close()
            drawPath(p, Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaTurquiaPreview() {
    BanderaTurquia(Modifier.size(width = 360.dp, height = 220.dp))
}