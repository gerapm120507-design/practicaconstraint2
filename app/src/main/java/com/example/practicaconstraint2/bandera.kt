
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

@Composable
fun BanderaJapon(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.background(Color.White)) {
        val (circulo) = createRefs()

        Canvas(Modifier.constrainAs(circulo) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            width = Dimension.percent(0.36f)
            height = Dimension.percent(0.60f)
        }) {
            drawCircle(
                color = Color(0xFFBC002D),
                radius = size.minDimension / 2f,
                center = Offset(size.width / 2f, size.height / 2f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaJaponPreview() {
    Box(Modifier.size(width = 360.dp, height = 240.dp)) {
        BanderaJapon(Modifier.fillMaxSize())
    }
}