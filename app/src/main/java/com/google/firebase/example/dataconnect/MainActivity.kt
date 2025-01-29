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

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.example.dataconnect.ui.theme.FirebaseDataConnectTheme
import kotlin.random.Random
import kotlinx.coroutines.tasks.await

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val snackBarHostState = remember { SnackbarHostState() }

            // Initialize Firebase Auth
            val firebaseAuth = Firebase.auth
            firebaseAuth.useEmulator("10.0.2.2", 9099)
            // Initialize Firebase Data Connect
            // TODO(developer): connect to Data Connect emulator

            LaunchedEffect(Unit) {
                try {
                    // If there's no user signed in, sign in an anonymous user
                    if (firebaseAuth.currentUser == null) {
                        firebaseAuth.signInAnonymously().await()
                        val newUsername = getRandomUsername()
                        // TODO(developer): add username to Firebase Data Connect
                    }
                } catch (e: Exception) {
                    // If you see a "Failed to connect to /10.0.2.2:9099" error
                    // it means the Android device couldn't connect to the
                    // Firebase Auth emulator
                    snackBarHostState.showSnackbar(
                        message = e.message.orEmpty(),
                        duration = SnackbarDuration.Indefinite
                    )
                }
            }

            // Show the UI
            FirebaseDataConnectTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(snackBarHostState)
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = MoviesRoute,
                        modifier = Modifier
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding),
                    ) {
                        composable<MoviesRoute> {
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(R.string.app_name),
                                    style = MaterialTheme.typography.headlineMedium,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                MoviesScreen(
                                    onMovieClicked = { movieId ->
                                        navController.navigate(
                                            route = MovieDetailRoute(movieId)
                                        )
                                    }
                                )
                            }
                        }
                        composable<MovieDetailRoute> {
                            val movieId = it.arguments!!.getString("movieId")!!
                            MovieDetailScreen(movieId)
                        }
                    }
                }
            }
        }
    }

    private fun getRandomUsername(): String = "user${Random.nextInt(1000)}"
}
