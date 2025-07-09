package com.example.sakeshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.data.SakeShop

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SakeShopListScreen(
    navController: NavController,
    viewModel: SakeShopListViewModel
) {
    val sakeShops by viewModel.sakeShops.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Sake Shops") })
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(sakeShops) { shop ->
                SakeShopListItem(shop = shop) {
                    navController.navigate("details/${shop.name}")
                }
            }
        }
    }
}

@Composable
fun SakeShopListItem(shop: SakeShop, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(shop.picture),
            contentDescription = shop.name,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = shop.name.orEmpty(), style = MaterialTheme.typography.headlineSmall)
            Row(){
                Icon(
                    imageVector =  Icons.Filled.LocationOn,
                    contentDescription = "LocationOn",
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(text = shop.address, style = MaterialTheme.typography.bodyMedium)
            }
            RatingBar(rating = shop.rating)
        }
    }
}