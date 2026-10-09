
package com.example.banderas.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun BanderaColombia(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (amarillo, azul, rojo) = createRefs()

        Box(Modifier.background(Color(0xFFFCD116)).constrainAs(amarillo) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            height = Dimension.percent(0.50f)
            width = Dimension.fillToConstraints
        })

        Box(Modifier.background(Color(0xFF003893)).constrainAs(azul) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(amarillo.bottom)
            height = Dimension.percent(0.25f)
            width = Dimension.fillToConstraints
        })

        Box(Modifier.background(Color(0xFFCE1126)).constrainAs(rojo) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(azul.bottom)
            bottom.linkTo(parent.bottom)
            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        })
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaColombiaPreview() {
    Box(Modifier.size(width = 360.dp, height = 220.dp)) {
        BanderaColombia(Modifier.fillMaxSize())
    }
}