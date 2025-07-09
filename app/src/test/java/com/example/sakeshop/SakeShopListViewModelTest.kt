package com.example.sakeshop

import com.example.data.SakeShop
import com.example.domain.GetSakeShopsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class SakeShopListViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private lateinit var getSakeShopsUseCase: GetSakeShopsUseCase
    private lateinit var viewModel: SakeShopListViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getSakeShopsUseCase = mock()
    }

    @Test
    fun `when viewmodel is initialized, sake shops are loaded`() = runBlockingTest {
        val mockShops = listOf(
            SakeShop("Shop 1", "Desc 1", "", 4.5, "Address 1", "", "")
        )
        whenever(getSakeShopsUseCase.invoke()).thenReturn(mockShops)

        viewModel = SakeShopListViewModel(getSakeShopsUseCase)

        assertEquals(mockShops, viewModel.sakeShops.value)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}