package kr.ac.jejunu.hwahae.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.ac.jejunu.hwahae.model.ProductService
import kr.ac.jejunu.hwahae.ui.adapter.ProductListAdapter

class ProductViewModelFactory(private val productAdapter : ProductListAdapter,private val api : ProductService) : ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(productAdapter,api) as T
    }
}