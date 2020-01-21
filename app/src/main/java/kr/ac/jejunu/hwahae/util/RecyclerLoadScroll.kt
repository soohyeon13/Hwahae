package kr.ac.jejunu.hwahae.util

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerLoadScroll : RecyclerView.OnScrollListener {

    private lateinit var mOnLoadMoreListener: OnLoadMoreListener

    private var mLayoutManager: RecyclerView.LayoutManager
    private var visibleHold = 5
    private var isLoading: Boolean = false
    private var lastVisibleItem: Int = 0
    private var totalItemCount: Int = 0

    constructor(layoutManager: GridLayoutManager) {
        this.mLayoutManager = layoutManager
    }

    fun setLoad() {
        isLoading = false
    }

    fun getLoad(): Boolean {
        return isLoading
    }

    fun setOnLoadMoreListener(mOnLoadMoreListener: OnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy > 0) return

        totalItemCount = mLayoutManager.itemCount

        lastVisibleItem = (mLayoutManager as GridLayoutManager).findLastVisibleItemPosition()

        if (!isLoading && totalItemCount <= lastVisibleItem + visibleHold) {
            mOnLoadMoreListener.onLoadMore()
            isLoading = true
        }
    }

    private fun getLastVisibleItem(lastVisibleItemPosition: IntArray): Int {
        var maxSize = 0
        for (i in lastVisibleItemPosition.indices) {
            if (i == 0) {
                maxSize = lastVisibleItemPosition[i]
            } else if (lastVisibleItemPosition[i] > maxSize) {
                maxSize = lastVisibleItemPosition[i]
            }
        }
        return maxSize
    }
}