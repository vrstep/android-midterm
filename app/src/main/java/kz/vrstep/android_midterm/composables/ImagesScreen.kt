package kz.vrstep.android_midterm.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ImagesScreen() {
    val images = listOf(
        "https://assets.laliga.com/squad/2024/t178/p593109/2048x2225/p593109_t178_2024_1_001_000.png",
        "https://assets.laliga.com/squad/2024/t178/p490541/2048x2225/p490541_t178_2024_1_001_000.png",
        "https://assets.laliga.com/squad/2024/t178/p219961/2048x2225/p219961_t178_2024_1_001_000.png",
        "https://assets.laliga.com/squad/2024/t178/p56764/2048x2225/p56764_t178_2024_1_001_000.png",
        "https://assets.laliga.com/squad/2024/t178/p209712/2048x2225/p209712_t178_2024_1_001_000.png",
        "https://assets.laliga.com/squad/2024/t178/p224444/2048x2225/p224444_t178_2024_1_001_000.png",
        "https://assets.laliga.com/squad/2024/t178/p593110/2048x2225/p593110_t178_2024_1_001_000.png"
    )

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(images.take(if (expanded) images.size else 3)) { index, imageUrl ->
                val width = if (index == 2 && !expanded) 180.dp else 200.dp // Show glimpse of 3rd image

                ImageCard(imageUrl, width)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { expanded = !expanded }) {
            Text(if (expanded) "Collapse" else "Show All")
        }
    }
}
