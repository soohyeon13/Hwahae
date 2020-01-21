package kr.ac.jejunu.hwahae.model.di

import kr.ac.jejunu.hwahae.model.ProductService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


var retrofit = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://6uqljnm1pb.execute-api.ap-northeast-2.amazonaws.com")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ProductService::class.java)
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get() as HttpLoggingInterceptor)
            .build()
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}
