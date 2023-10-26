package com.yonatanrs.moviedatabase.core.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.yonatanrs.moviedatabase.core.misc.ActivityConfiguration

abstract class BaseActivity<T: ViewBinding>: AppCompatActivity() {
    protected var viewBinding: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = onGetViewBinding()
        this.setContentView(viewBinding?.root)

        this.supportActionBar?.also {
            onGetActivityConfiguration().also { config ->
                if (config.titleResId > 0) it.setTitle(config.titleResId)
                it.setHomeButtonEnabled(config.supportBack)
                it.setDisplayHomeAsUpEnabled(config.supportBack)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    protected open fun onGetActivityConfiguration(): ActivityConfiguration {
        return ActivityConfiguration(0, true)
    }

    protected abstract fun onGetViewBinding(): T

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}