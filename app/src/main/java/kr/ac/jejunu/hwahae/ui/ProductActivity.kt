package kr.ac.jejunu.hwahae.ui

import androidx.lifecycle.ViewModelProviders
import kr.ac.jejunu.hwahae.R
import kr.ac.jejunu.hwahae.base.BaseActivity
import kr.ac.jejunu.hwahae.databinding.ProductActivityBinding
import kr.ac.jejunu.hwahae.model.ProductService
import kr.ac.jejunu.hwahae.ui.adapter.ProductListAdapter
import org.koin.android.ext.android.inject

class ProductActivity : BaseActivity<ProductActivityBinding,ProductViewModel>(R.layout.product_activity) {

    private val adapter = ProductListAdapter()
    private val product : ProductService by inject()
    private lateinit var productListViewModel: ProductViewModel
    private lateinit var productListViewModelFactory: ProductViewModelFactory

    override fun initView() {
        productListViewModelFactory = ProductViewModelFactory(adapter,product)

        productListViewModel = ViewModelProviders.of(this,productListViewModelFactory)
            .get(ProductViewModel::class.java)

        binding.productViewModel = productListViewModel
    }
}
