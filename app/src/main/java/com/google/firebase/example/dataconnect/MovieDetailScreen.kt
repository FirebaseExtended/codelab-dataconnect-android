/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.firebase.example.dataconnect

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.firebase.example.dataconnect.ui.components.LoadingScreen
import java.util.UUID
import kotlinx.serialization.Serializable

@Composable
fun MovieDetailScreen(
    movieId: String
) {

}

@Composable
fun MovieDetails(
    movieTitle: String,
    movieImageUrl: String,
    movieGenre: String? = null,
    movieRating: Double? = 0.0,
    movieReleaseYear: Int? = 2024,
    movieDescription: String? = null
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = movieTitle,
            style = MaterialTheme.typography.headlineLarge
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$movieReleaseYear",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(end = 4.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Outlined.Star, "Favorite")
            Text(
                text = "$movieRating",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 2.dp)
            )
        }
        Row {
            AsyncImage(
                model = movieImageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .aspectRatio(9f / 16f)
                    .padding(vertical = 8.dp)
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                movieGenre?.let {
                    SuggestionChip(
                        onClick = { },
                        label = { Text(it) },
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                    )
                }
                Text(
                    text = movieDescription ?: stringResource(R.string.description_not_available),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Serializable
data class MovieDetailRoute(val movieId: String)
