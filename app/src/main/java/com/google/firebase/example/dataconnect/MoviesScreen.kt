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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.serialization.Serializable

@Composable
fun MoviesScreen(
    onMovieClicked: (id: String) -> Unit
) {
    // TODO(developer): run the query to list movies
}


/**
 * Used to display each movie item in the list.
 */
@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    tileWidth: Dp = 150.dp,
    movieId: String,
    movieTitle: String,
    movieImageUrl: String,
    movieGenre: String? = null,
    onMovieClicked: (movieId: String) -> Unit
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .sizeIn(maxWidth = tileWidth)
            .clickable {
                onMovieClicked(movieId)
            },
    ) {
        AsyncImage(
            model = movieImageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.aspectRatio(9f / 16f)
        )
        Text(
            text = movieTitle,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        movieGenre?.let {
            Text(
                text = it,
                modifier = Modifier.padding(bottom = 8.dp, start = 8.dp, end = 8.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Serializable
object MoviesRoute
