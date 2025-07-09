package com.example.domain

import com.example.data.SakeShop
import com.example.data.SakeShopRepository

class GetSakeShopsUseCase(private val repository: SakeShopRepository) {
    operator fun invoke(): List<SakeShop> {
        return repository.getSakeShops()
    }
}