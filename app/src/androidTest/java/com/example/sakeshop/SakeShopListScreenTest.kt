package com.example.sakeshop

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.example.data.SakeShop
import com.example.domain.GetSakeShopsUseCase
import org.junit.Rule
import org.junit.Test

class SakeShopListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun sakeShopListScreen_displaysListOfShops() {
        val mockShops = listOf(
            SakeShop("Test Shop", "A great place", "", 4.0, "123 Test St", "", "")
        )
        val getSakeShopsUseCase: GetSakeShopsUseCase = mock()
        whenever(getSakeShopsUseCase.invoke()).thenReturn(mockShops)

        val viewModel = SakeShopListViewModel(getSakeShopsUseCase)

        composeTestRule.setContent {
            val navController = rememberNavController()
            SakeShopListScreen(navController = navController, viewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Test Shop").assertIsDisplayed()
        composeTestRule.onNodeWithText("123 Test St").assertIsDisplayed()
    }
}