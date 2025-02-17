package com.zak.afir.composepl.basic_layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow.Companion.Ellipsis
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import com.zak.afir.composepl.R
import com.zak.afir.composepl.ui.theme.ComposePLTheme

private val tags = listOf(
    "City Center",
    "Luxury",
    "Instant booking",
    "Exclusive deal",
    "Early bird discount",
    "Romantic gateway",
    "24/7 support"
)

private val offers = mapOf(
    R.drawable.bed to "Bed",
    R.drawable.breakfast to "Breakfast",
    R.drawable.cutlery to "Cutlery",
    R.drawable.pawprint to "Pet friendly",
    R.drawable.serving_dish to "Dinner",
    R.drawable.snowflake to "Air conditioning",
    R.drawable.wi_fi_icon to "Wi-Fi",
    R.drawable.television to "Television"

)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 250.dp),
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
        item {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        item {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                tags.forEach {
                    AssistChip(onClick = {}, label = {
                        Text(
                            text = it
                        )
                    })
                }
            }
        }
        item {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        item {
            Text(
                fontSize = 13.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
            """.trimIndent()
            )
        }
        item {
            Text(
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = "What we offer",
                fontWeight = FontWeight.Bold
            )
        }
        item {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                items(offers.entries.toList()) { (drawableId, label) ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(
                            Color.Gray.copy(alpha = 0.3f)
                        )
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(drawableId),
                            contentDescription = label,
                            modifier = Modifier.size(36.dp)
                        )
                        Text(text = label, fontSize = 13.sp)
                    }
                }
            }
        }
        item {
            Button(onClick = {}, modifier = Modifier.padding(16.dp).widthIn(
                max = 400.dp
            ).fillMaxWidth()) {
                Text(text = "Book now!")
            }
        }
    }
}

@Composable
fun HotelFadedBanner(modifier: Modifier = Modifier) {
    val windowClas = currentWindowAdaptiveInfo().windowSizeClass
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
                fontSize = when (windowClas.windowWidthSizeClass) {
                    WindowWidthSizeClass.COMPACT -> 18.sp
                    WindowWidthSizeClass.MEDIUM -> 24.sp
                    WindowWidthSizeClass.EXPANDED -> 28.sp
                    else -> 18.sp
                }
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
                val fontSizeMultiplier = when (windowClas.windowWidthSizeClass) {
                    WindowWidthSizeClass.COMPACT -> 1f
                    WindowWidthSizeClass.MEDIUM -> 1.2f
                    WindowWidthSizeClass.EXPANDED -> 1.5f
                    else -> 1f
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 20.sp * fontSizeMultiplier,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("420$/")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 14.sp * fontSizeMultiplier,
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

@Preview(device = Devices.NEXUS_10)
@Composable
fun HotelBookingScreenTabletPreview() {
    ComposePLTheme {
        HotelBookingScreen()
    }
}