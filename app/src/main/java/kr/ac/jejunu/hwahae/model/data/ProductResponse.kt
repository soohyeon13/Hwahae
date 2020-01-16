package kr.ac.jejunu.hwahae.model.data

import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("body")
    val productList : List<Product>? = null
)