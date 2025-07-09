package com.example.sakeshop

import androidx.lifecycle.ViewModel
import com.example.data.SakeShop
import com.example.domain.GetSakeShopsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SakeShopListViewModel(private val getSakeShopsUseCase: GetSakeShopsUseCase) : ViewModel() {

    private val _sakeShops = MutableStateFlow<List<SakeShop>>(emptyList())
    val sakeShops: StateFlow<List<SakeShop>> = _sakeShops

    init {
        _sakeShops.value = getSakeShopsUseCase()
    }
}