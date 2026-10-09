
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

@Composable
fun BanderaBrasil(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier.background(Color(0xFF009739))
    ) {
        val (figuras) = createRefs()

        Canvas(Modifier.constrainAs(figuras) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            width = androidx.constraintlayout.compose.Dimension.fillToConstraints
            height = androidx.constraintlayout.compose.Dimension.fillToConstraints
        }) {
            val w = size.width
            val h = size.height

            val rombo = Path().apply {
                moveTo(w * 0.5f, h * 0.12f)
                lineTo(w * 0.92f, h * 0.5f)
                lineTo(w * 0.5f, h * 0.88f)
                lineTo(w * 0.08f, h * 0.5f)
                close()
            }

            drawPath(rombo, Color(0xFFFFDF00))

            drawCircle(
                color = Color(0xFF002776),
                radius = h * 0.27f,
                center = Offset(w * 0.5f, h * 0.5f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaBrasilPreview() {
    Box(Modifier.size(width = 360.dp, height = 220.dp)) {
        BanderaBrasil(Modifier.fillMaxSize())
    }
}