package kr.ac.jejunu.hwahae.model

import io.reactivex.Observable
import kr.ac.jejunu.hwahae.model.data.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {
    @Headers("Content-Type: application/json")
    @GET("prod/products")
    fun defaultOliyList(): Observable<ProductResponse>

    @Headers("Content-Type: application/json")
    @GET("prod/products")
    fun skinTypeList(@Query("skin_type") skin: String,@Query("page") page : Int): Observable<ProductResponse>

    @GET("products?skin_type={skin}&page={pageNum}")
    fun skinTypePageList(
        @Path("skin") skin: String
        , @Path("pageNum") pageNum: Int
    ): Observable<ProductResponse>

    @GET("products?skin_type={skin}%search={keyword}")
    fun keywordList(
        @Path("skin") skin: String,
        @Path("keyword") keyword: String
    ): Observable<ProductResponse>
}