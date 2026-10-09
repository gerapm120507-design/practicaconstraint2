package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun BanderaButan(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (fondo, dragon) = createRefs()

        // Fondo amarillo y naranja
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

            // Triángulo amarillo
            val amarillo = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, 0f)
                lineTo(0f, h)
                close()
            }
            drawPath(amarillo, Color(0xFFFFC928))

            // Triángulo naranja
            val naranja = Path().apply {
                moveTo(w, 0f)
                lineTo(w, h)
                lineTo(0f, h)
                close()
            }
            drawPath(naranja, Color(0xFFFF4E12))
        }

        // Imagen PNG del dragón
        Image(
            painter = painterResource(
                id = R.drawable.dragon_butan
            ),
            contentDescription = "Dragón de la bandera de Bután",
            contentScale = ContentScale.Fit,
            modifier = Modifier.constrainAs(dragon) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)

                width = Dimension.percent(0.55f)
                height = Dimension.percent(0.75f)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaButanPreview() {
    BanderaButan(
        Modifier.size(width = 360.dp, height = 240.dp)
    )
}