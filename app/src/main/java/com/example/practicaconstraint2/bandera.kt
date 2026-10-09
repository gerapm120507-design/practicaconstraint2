
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

private val NegroAlemania = Color(0xFF000000)
private val RojoAlemania = Color(0xFFDD0000)
private val AmarilloAlemania = Color(0xFFFFCE00)

@Composable
fun BanderaAlemania(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier) {
        val (negro, rojo, amarillo) = createRefs()

        Box(
            modifier = Modifier
                .background(NegroAlemania)
                .constrainAs(negro) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    height = Dimension.percent(1f / 3f)
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(RojoAlemania)
                .constrainAs(rojo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(negro.bottom)
                    height = Dimension.percent(1f / 3f)
                    width = Dimension.fillToConstraints
                }
        )

        Box(
            modifier = Modifier
                .background(AmarilloAlemania)
                .constrainAs(amarillo) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(rojo.bottom)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaAlemaniaPreview() {
    Box(
        modifier = Modifier.size(
            width = 360.dp,
            height = 220.dp
        )
    ) {
        BanderaAlemania(
            modifier = Modifier.fillMaxSize()
        )
    }
}