package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.practicaconstraint2.R

@Composable
fun BanderaKiribati(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (fondo, detalle) = createRefs()

        Canvas(
            modifier = Modifier.constrainAs(fondo) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        ) {
            val w = size.width
            val h = size.height

            drawRect(Color(0xFF003F87))

            drawRect(
                color = Color(0xFFCE1126),
                size = androidx.compose.ui.geometry.Size(w, h * 0.48f)
            )

            for (i in 0 until 3) {
                val y = h * (0.63f + i * 0.12f)

                val ola = Path().apply {
                    moveTo(0f, y)
                    cubicTo(
                        w * 0.20f, y - h * 0.08f,
                        w * 0.30f, y + h * 0.08f,
                        w * 0.50f, y
                    )
                    cubicTo(
                        w * 0.70f, y - h * 0.08f,
                        w * 0.80f, y + h * 0.08f,
                        w, y
                    )
                }

                drawPath(
                    path = ola,
                    color = Color.White,
                    style = androidx.compose.ui.graphics.drawscope.Stroke(
                        width = h * 0.025f
                    )
                )
            }
        }

        Image(
            painter = painterResource(
                id = R.drawable.kiribati_detail
            ),
            contentDescription = "Sol y ave de la bandera de Kiribati",
            contentScale = ContentScale.Fit,
            modifier = Modifier.constrainAs(detalle) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)

                width = Dimension.percent(0.55f)
                height = Dimension.percent(0.48f)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaKiribatiPreview() {
    BanderaKiribati(
        Modifier.size(width = 360.dp, height = 220.dp)
    )
}