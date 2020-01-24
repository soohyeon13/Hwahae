package kr.ac.jejunu.hwahae.ui

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kr.ac.jejunu.hwahae.R
import kr.ac.jejunu.hwahae.base.BaseActivity
import kr.ac.jejunu.hwahae.databinding.ProductActivityBinding
import kr.ac.jejunu.hwahae.model.ProductService
import kr.ac.jejunu.hwahae.ui.adapter.ProductListAdapter
import org.koin.android.ext.android.inject

class ProductActivity : BaseActivity<ProductActivityBinding>(R.layout.product_activity) {

    private val adapter = ProductListAdapter()
    private val product : ProductService by inject()
    private lateinit var productListViewModel: ProductViewModel
    private lateinit var productListViewModelFactory: ProductViewModelFactory
    private val skinTypes = arrayOf("모든 피부 타입","oily", "dry", "sensitive")
    private var skinType :String =""
    override fun initView() {
        val spinnerAdapter = ArrayAdapter(
            this,
//            R.layout.custom_spinner,
            android.R.layout.simple_spinner_dropdown_item,
            skinTypes
        )

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.spinner.adapter = spinnerAdapter
        binding.spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                skinType = skinTypes[position]
                binding.productViewModel?.getTypeProducts(skinType,1)
            }

        }

        binding.productList.apply {
            layoutManager = GridLayoutManager(this@ProductActivity,2)
            clipToPadding = false
            clipChildren = false
        }
        productListViewModelFactory = ProductViewModelFactory(adapter,product)

        productListViewModel = ViewModelProviders.of(this,productListViewModelFactory)
            .get(ProductViewModel::class.java)

        binding.productViewModel = productListViewModel
    }
}
