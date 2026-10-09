
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
fun BanderaEspana(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (rojoSuperior, amarillo, rojoInferior) = createRefs()

        Box(Modifier.background(Color(0xFFAA151B)).constrainAs(rojoSuperior) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            height = Dimension.percent(0.25f)
            width = Dimension.fillToConstraints
        })

        Box(Modifier.background(Color(0xFFF1BF00)).constrainAs(amarillo) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(rojoSuperior.bottom)
            height = Dimension.percent(0.50f)
            width = Dimension.fillToConstraints
        })

        Box(Modifier.background(Color(0xFFAA151B)).constrainAs(rojoInferior) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(amarillo.bottom)
            bottom.linkTo(parent.bottom)
            height = Dimension.fillToConstraints
            width = Dimension.fillToConstraints
        })
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaEspanaPreview() {
    Box(Modifier.size(width = 360.dp, height = 220.dp)) {
        BanderaEspana(Modifier.fillMaxSize())
    }
}