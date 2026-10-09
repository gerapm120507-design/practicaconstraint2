
package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun BanderaSuiza(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.background(Color(0xFFD52B1E))) {
        val (vertical, horizontal) = createRefs()

        Box(Modifier.background(Color.White).constrainAs(vertical) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            width = Dimension.percent(0.20f)
            height = Dimension.percent(0.62f)
        })

        Box(Modifier.background(Color.White).constrainAs(horizontal) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            width = Dimension.percent(0.62f)
            height = Dimension.percent(0.20f)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaSuizaPreview() {
    BanderaSuiza(Modifier.size(240.dp))
}