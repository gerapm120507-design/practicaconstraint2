
package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
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

private val Negro = Color(0xFF080808)
private val Amarillo = Color(0xFFFFE500)
private val Blanco = Color.White
private val Azul = Color(0xFF2121DE)
private val Rojo = Color(0xFFFF0000)

// Dibuja una figura usando una cuadrícula de píxeles.
private fun androidx.compose.ui.graphics.drawscope.DrawScope.dibujarPixelArt(
    mapa: List<String>,
    colorPorPixel: (Char) -> Color,
    filas: Int,
    columnas: Int
) {
    val pixel = minOf(size.width / columnas, size.height / filas)
    val anchoTotal = pixel * columnas
    val altoTotal = pixel * filas
    val inicioX = (size.width - anchoTotal) / 2f
    val inicioY = (size.height - altoTotal) / 2f

    mapa.forEachIndexed { fila, linea ->
        linea.forEachIndexed { columna, simbolo ->
            if (simbolo != '.') {
                drawRect(
                    color = colorPorPixel(simbolo),
                    topLeft = androidx.compose.ui.geometry.Offset(
                        inicioX + columna * pixel,
                        inicioY + fila * pixel
                    ),
                    size = androidx.compose.ui.geometry.Size(pixel, pixel)
                )
            }
        }
    }
}

@Composable
fun PacmanScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier.background(Negro)
    ) {
        val (titulo, laberinto, pacman, fantasma) = createRefs()

        // Título
        androidx.compose.material3.Text(
            text = "PAC-MAN",
            color = Amarillo,
            modifier = Modifier.constrainAs(titulo) {
                top.linkTo(parent.top, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Box(
            modifier = Modifier
                .background(Color(0xFF101020))
                .constrainAs(laberinto) {
                    top.linkTo(titulo.bottom, margin = 18.dp)
                    start.linkTo(parent.start, margin = 20.dp)
                    end.linkTo(parent.end, margin = 20.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.percent(0.55f)
                }
        ) {
            Canvas(Modifier.fillMaxSize()) {
                val grosor = size.width * 0.018f

                drawRect(
                    color = Azul,
                    style = androidx.compose.ui.graphics.drawscope.Stroke(grosor)
                )

                drawRect(
                    color = Azul,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.12f,
                        size.height * 0.18f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.28f,
                        size.height * 0.12f
                    ),
                    style = androidx.compose.ui.graphics.drawscope.Stroke(grosor)
                )

                drawRect(
                    color = Azul,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.60f,
                        size.height * 0.18f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.28f,
                        size.height * 0.12f
                    ),
                    style = androidx.compose.ui.graphics.drawscope.Stroke(grosor)
                )

                drawRect(
                    color = Azul,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.12f,
                        size.height * 0.68f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.28f,
                        size.height * 0.12f
                    ),
                    style = androidx.compose.ui.graphics.drawscope.Stroke(grosor)
                )

                drawRect(
                    color = Azul,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        size.width * 0.60f,
                        size.height * 0.68f
                    ),
                    size = androidx.compose.ui.geometry.Size(
                        size.width * 0.28f,
                        size.height * 0.12f
                    ),
                    style = androidx.compose.ui.graphics.drawscope.Stroke(grosor)
                )

                for (i in 0 until 9) {
                    drawCircle(
                        color = Color(0xFFFFE8A3),
                        radius = grosor * 0.65f,
                        center = androidx.compose.ui.geometry.Offset(
                            size.width * (0.12f + i * 0.095f),
                            size.height * 0.50f
                        )
                    )
                }
            }
        }

        Canvas(
            modifier = Modifier.constrainAs(pacman) {
                start.linkTo(parent.start, margin = 45.dp)
                top.linkTo(laberinto.bottom, margin = 22.dp)
                width = Dimension.value(112.dp)
                height = Dimension.value(112.dp)
            }
        ) {
            val mapa = listOf(
                "....YYYYYY....",
                "..YYYYYYYYYY..",
                ".YYYYYYYYYYYY.",
                "YYYYYYYYYYY...",
                "YYYYYYYY......",
                "YYYYY.........",
                "YYYYY.........",
                "YYYYYY........",
                "YYYYYYYY......",
                "YYYYYYYYYYY...",
                ".YYYYYYYYYYYY.",
                "..YYYYYYYYYY..",
                "....YYYYYY...."
            )

            dibujarPixelArt(
                mapa = mapa,
                filas = 13,
                columnas = 14,
                colorPorPixel = { Amarillo }
            )
        }

        Canvas(
            modifier = Modifier.constrainAs(fantasma) {
                end.linkTo(parent.end, margin = 45.dp)
                top.linkTo(pacman.top)
                width = Dimension.value(112.dp)
                height = Dimension.value(112.dp)
            }
        ) {
            val mapa = listOf(
                "...RRRRRR...",
                "..RRRRRRRR..",
                ".RRRRRRRRRR.",
                "RRRRRRRRRRRR",
                "RRWWRRRRWWRR",
                "RRWWRRRRWWRR",
                "RRRRRRRRRRRR",
                "RRRRRRRRRRRR",
                "RRRRRRRRRRRR",
                "RRRRRRRRRRRR",
                "RR.RR.RR.RR."
            )

            dibujarPixelArt(
                mapa = mapa,
                filas = 11,
                columnas = 12,
                colorPorPixel = {
                    when (it) {
                        'R' -> Rojo
                        'W' -> Blanco
                        else -> Negro
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PacmanScreenPreview() {
    PacmanScreen(
        modifier = Modifier.fillMaxSize()
    )
}