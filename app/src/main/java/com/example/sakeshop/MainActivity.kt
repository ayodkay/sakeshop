package com.example.sakeshop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.data.SakeShopRepositoryImpl
import com.example.domain.GetSakeShopsUseCase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val repository = SakeShopRepositoryImpl(applicationContext)
            val getSakeShopsUseCase = GetSakeShopsUseCase(repository)
            val viewModel = SakeShopListViewModel(getSakeShopsUseCase)

            NavHost(navController = navController, startDestination = "list") {
                composable("list") {
                    SakeShopListScreen(navController = navController, viewModel = viewModel)
                }
                composable("details/{shopName}") { backStackEntry ->
                    val shopName = backStackEntry.arguments?.getString("shopName")
                    val shop = viewModel.sakeShops.value.find { it.name == shopName }
                    shop?.let { SakeShopDetailScreen(shop = it) }
                }
            }
        }
    }
}