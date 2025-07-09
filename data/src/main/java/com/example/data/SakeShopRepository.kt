package com.example.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

interface SakeShopRepository {
    fun getSakeShops(): List<SakeShop>
}

class SakeShopRepositoryImpl(private val context: Context) : SakeShopRepository {
    override fun getSakeShops(): List<SakeShop> {
        val inputStream = context.assets.open("sake_shops.json")
        val reader = InputStreamReader(inputStream)
        val sakeShopListType = object : TypeToken<List<SakeShop>>() {}.type
        return Gson().fromJson(reader, sakeShopListType)
    }
}