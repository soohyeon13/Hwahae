package kr.ac.jejunu.hwahae.model.data

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("thumbnail_image")
    val thumbnail_image: String?,
    @SerializedName("title")
    val  title: String?,
    @SerializedName("price")
    val  price: String?,
    @SerializedName("skin_score")
    val skin_score: Int?
)