
package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
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
fun BanderaChile(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (blanco, rojo, azul, estrella) = createRefs()

        Box(Modifier.background(Color.White).constrainAs(blanco) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            height = Dimension.percent(0.5f)
            width = Dimension.fillToConstraints
        })

        Box(Modifier.background(Color(0xFFD52B1E)).constrainAs(rojo) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(blanco.bottom)
            bottom.linkTo(parent.bottom)
            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        })

        Box(Modifier.background(Color(0xFF0039A6)).constrainAs(azul) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            width = Dimension.percent(1f / 3f)
            height = Dimension.percent(0.5f)
        })

        Canvas(Modifier.constrainAs(estrella) {
            start.linkTo(azul.start)
            end.linkTo(azul.end)
            top.linkTo(azul.top)
            bottom.linkTo(azul.bottom)
            width = Dimension.percent(0.12f)
            height = Dimension.percent(0.20f)
        }) {
            val cx = size.width / 2f
            val cy = size.height / 2f
            val outer = size.minDimension / 2f
            val inner = outer * 0.42f

            val estrellaPath = Path()
            for (i in 0 until 10) {
                val angulo = Math.PI * i / 5.0 - Math.PI / 2.0
                val radio = if (i % 2 == 0) outer else inner
                val x = cx + cos(angulo).toFloat() * radio
                val y = cy + sin(angulo).toFloat() * radio

                if (i == 0) estrellaPath.moveTo(x, y)
                else estrellaPath.lineTo(x, y)
            }
            estrellaPath.close()
            drawPath(estrellaPath, Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaChilePreview() {
    Box(Modifier.size(width = 360.dp, height = 220.dp)) {
        BanderaChile(Modifier.fillMaxSize())
    }
}