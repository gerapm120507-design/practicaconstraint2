
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaArgentina(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (celesteSuperior, blanco, celesteInferior, sol) = createRefs()

        Box(Modifier.background(Color(0xFF74ACDF)).constrainAs(celesteSuperior) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            height = Dimension.percent(1f / 3f)
            width = Dimension.fillToConstraints
        })

        Box(Modifier.background(Color.White).constrainAs(blanco) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(celesteSuperior.bottom)
            height = Dimension.percent(1f / 3f)
            width = Dimension.fillToConstraints
        })

        Box(Modifier.background(Color(0xFF74ACDF)).constrainAs(celesteInferior) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(blanco.bottom)
            bottom.linkTo(parent.bottom)
            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        })

        Canvas(Modifier.constrainAs(sol) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(blanco.top)
            bottom.linkTo(blanco.bottom)
            width = Dimension.percent(0.13f)
            height = Dimension.percent(0.22f)
        }) {
            val centro = Offset(size.width / 2f, size.height / 2f)
            val radio = size.minDimension * 0.22f

            drawCircle(Color(0xFFF6B40E), radius = radio, center = centro)

            for (i in 0 until 12) {
                val angulo = Math.PI * 2.0 * i / 12.0
                val inicio = radio * 1.25f
                val fin = radio * 1.8f

                drawLine(
                    color = Color(0xFFF6B40E),
                    start = Offset(
                        centro.x + cos(angulo).toFloat() * inicio,
                        centro.y + sin(angulo).toFloat() * inicio
                    ),
                    end = Offset(
                        centro.x + cos(angulo).toFloat() * fin,
                        centro.y + sin(angulo).toFloat() * fin
                    ),
                    strokeWidth = radio * 0.25f
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaArgentinaPreview() {
    Box(Modifier.size(width = 360.dp, height = 220.dp)) {
        BanderaArgentina(Modifier.fillMaxSize())
    }
}