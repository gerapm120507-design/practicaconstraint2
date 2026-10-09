
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

private val AzulFrancia = Color(0xFF0055A4)
private val RojoFrancia = Color(0xFFEF4135)

@Composable
fun BanderaFrancia(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (azul, blanco, rojo) = createRefs()

        Box(
            modifier = Modifier
                .background(AzulFrancia)
                .constrainAs(azul) {
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
                    start.linkTo(azul.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.percent(1f / 3f)
                    height = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(RojoFrancia)
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
fun BanderaFranciaPreview() {
    Box(
        modifier = Modifier.size(
            width = 360.dp,
            height = 240.dp
        )
    ) {
        BanderaFrancia(
            modifier = Modifier.fillMaxSize()
        )
    }
}