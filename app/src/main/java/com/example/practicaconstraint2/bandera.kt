package com.example.banderas.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.practicaconstraint2.R
private val VerdeMexico = Color(0xFF006847)
private val RojoMexico = Color(0xFFCE1126)

@Composable
fun BanderaMexico(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {
        val (verde, blanco, rojo, escudo) = createRefs()

        Box(
            modifier = Modifier
                .background(VerdeMexico)
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
                .background(RojoMexico)
                .constrainAs(rojo) {
                    start.linkTo(blanco.end)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        )

        Image(
            painter = painterResource(id = R.drawable.escudo_mexico),
            contentDescription = "Escudo nacional de México",
            contentScale = ContentScale.Fit,
            modifier = Modifier.constrainAs(escudo) {
                start.linkTo(blanco.start)
                end.linkTo(blanco.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)

                width = Dimension.percent(0.23f)
                height = Dimension.percent(0.43f)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaMexicoPreview() {
    Surface(
        modifier = Modifier.size(width = 360.dp, height = 220.dp)
    ) {
        BanderaMexico()
    }
}