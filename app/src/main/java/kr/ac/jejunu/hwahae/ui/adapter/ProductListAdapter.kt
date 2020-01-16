package kr.ac.jejunu.hwahae.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kr.ac.jejunu.hwahae.R
import kr.ac.jejunu.hwahae.databinding.ProductItemBinding
import kr.ac.jejunu.hwahae.model.data.Product

class ProductListAdapter :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    private var productList : List<Product> = listOf()

    class ProductViewHolder(private val binding : ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Product) {
            binding.product =item
        }
    }

    fun setProduct(product : List<Product>) {
        this.productList = product
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ProductViewHolder {
        return ProductViewHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }
}