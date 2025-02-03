package com.zak.afir.composepl.basic_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zak.afir.composepl.R
import com.zak.afir.composepl.ui.theme.ComposePLTheme

@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Box {
                Image(
                    modifier = Modifier.fillMaxWidth().heightIn(max = 250.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.living_room),
                    contentDescription = null
                )
                HotelFadedBanner(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(
                            Alignment.BottomCenter
                        )
                )
            }
        }
    }
}

@Composable
fun HotelFadedBanner(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color.White.copy(alpha = 0.7f))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Hotel California Strawberry",
                maxLines = 2,
                overflow = Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            LabeledIcon(
                icon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color.DarkGray
                    )
                },
                text = "Los Angeles, California"
            )
            LabeledIcon(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                },
                text = "4.9 (13K reviews)"
            )
        }
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("420$/")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append("night")
                }
            },
        )
    }
}

@Composable
fun LabeledIcon(icon: @Composable () -> Unit, text: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        icon()
        Text(text = text, fontSize = 13.sp)
    }
}

@Preview
@Composable
fun HotelBookingScreenPreview() {
    ComposePLTheme {
        HotelBookingScreen()
    }
}

@Preview (device = Devices.NEXUS_10)
@Composable
fun HotelBookingScreenTabletPreview() {
    ComposePLTheme {
        HotelBookingScreen()
    }
}