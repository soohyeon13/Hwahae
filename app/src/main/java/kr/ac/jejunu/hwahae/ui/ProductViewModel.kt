package kr.ac.jejunu.hwahae.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.ac.jejunu.hwahae.base.BaseViewModel
import kr.ac.jejunu.hwahae.model.ProductService
import kr.ac.jejunu.hwahae.model.data.Product
import kr.ac.jejunu.hwahae.ui.adapter.ProductListAdapter

class ProductViewModel(
    private val productAdapter: ProductListAdapter,
    private val api: ProductService
) : BaseViewModel() {

    private val _items = MutableLiveData<List<Product>>()
    private val _adapter = MutableLiveData<ProductListAdapter>().apply { value = productAdapter }

    val items: LiveData<List<Product>> get() = _items
    val adapter: LiveData<ProductListAdapter> get() = _adapter

    init {
        getProducts()
    }

    private fun getProducts() {
        addDisposable(
            api.defaultOliyList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userResponse ->
                    _items.value = userResponse.productList
                }, { error ->
                    Log.e("product List", error.message)
                })
        )
    }

    fun typeProducts(skinType : String,page : Int) {
        addDisposable(
            api.skinTypeList(skinType,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({ userResponse ->
                    _items.value = userResponse.productList
                },{ error ->
                Log.e("product List",error.message)
            })
        )
    }
}