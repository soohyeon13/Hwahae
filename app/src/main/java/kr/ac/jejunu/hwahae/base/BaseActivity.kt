package kr.ac.jejunu.hwahae.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding> (
    private val layoutId : Int
) : AppCompatActivity() {
    lateinit var binding : T
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layoutId)
        binding.setLifecycleOwner { this.lifecycle }
        initView()
    }
}