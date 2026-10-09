
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

private val VerdeItalia = Color(0xFF009246)
private val RojoItalia = Color(0xFFCE2B37)

@Composable
fun BanderaItalia(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (verde, blanco, rojo) = createRefs()

        Box(
            modifier = Modifier
                .background(VerdeItalia)
                .constrainAs(verde) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.percent(1f / 3f)
                    height = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(Color.White)
                .constrainAs(blanco) {
                    start.linkTo(verde.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.percent(1f / 3f)
                    height = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(RojoItalia)
                .constrainAs(rojo) {
                    start.linkTo(blanco.end)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaItaliaPreview() {
    Box(
        modifier = Modifier.size(
            width = 360.dp,
            height = 240.dp
        )
    ) {
        BanderaItalia(
            modifier = Modifier.fillMaxSize()
        )
    }
}