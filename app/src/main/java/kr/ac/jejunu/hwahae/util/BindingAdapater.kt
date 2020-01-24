package kr.ac.jejunu.hwahae.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.ac.jejunu.hwahae.model.data.Product
import kr.ac.jejunu.hwahae.ui.adapter.ProductListAdapter


@BindingAdapter("imgUrl")
fun setImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .centerCrop()
        .into(view)
}

@BindingAdapter("bind_adapter")
fun setBindAdapter(view: RecyclerView, adapter: ProductListAdapter?) {
    adapter?.let {
        view.adapter = it
    }
}

@BindingAdapter("bind_items")
fun setBindItems(view: RecyclerView, items: List<Product>?) {
    items?.let {
        val adapter = view.adapter as ProductListAdapter
        adapter.setProducts(items)
        adapter.notifyDataSetChanged()
    }
}