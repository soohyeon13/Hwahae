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

class ProductViewModel(private val productAdapter : ProductListAdapter
                       ,private val api : ProductService)
    : BaseViewModel() {

    private val TAG :String = "ProductViewModel"
    private val _items = MutableLiveData<List<Product>>()
    private val _adapter = MutableLiveData<ProductListAdapter>().apply { value = productAdapter }

    val items : LiveData<List<Product>> get() = _items
    val adapter : LiveData<ProductListAdapter> get() = _adapter

    init {
        getProduct()
    }

    private fun getProduct() {
        addDisposable(
            api.defaultOliyList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    userResponse -> _items.value = userResponse.productList
                    Log.d(TAG, userResponse.productList?.get(0)?.title)
                }, {
                    error -> Log.e("product List",error.message)
                })
        )
    }

}