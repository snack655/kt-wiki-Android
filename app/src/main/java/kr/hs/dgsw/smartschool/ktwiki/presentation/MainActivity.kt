package kr.hs.dgsw.smartschool.ktwiki.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.smartschool.ktwiki.presentation.document.list.DocumentListScreen
import kr.hs.dgsw.smartschool.ktwiki.presentation.ui.theme.KTwikiTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KTwikiTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.DocumentListScreen.route
                    ) {
                        composable(
                            route = Screen.DocumentListScreen.route
                        ) {
                            DocumentListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.DocumentDetailScreen.route + "/{idx}"
                        ) {
                            Screen.DocumentDetailScreen
                        }
                    }
                }
            }
        }
    }
}