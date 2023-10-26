package com.yonatanrs.moviedatabase.presentation.activity

import android.os.Bundle
import com.yonatanrs.moviedatabase.R
import com.yonatanrs.moviedatabase.core.misc.ActivityConfiguration
import com.yonatanrs.moviedatabase.core.presentation.BaseActivity
import com.yonatanrs.moviedatabase.databinding.ActivityDiscoveredMovieBasedGenreBinding
import com.yonatanrs.moviedatabase.presentation.Constant
import com.yonatanrs.moviedatabase.presentation.fragment.DiscoveredMovieBasedGenrePagingRecyclerViewFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
@AndroidEntryPoint
class DiscoveredMovieBasedGenreActivity: BaseActivity<ActivityDiscoveredMovieBasedGenreBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding?.also {
            val genreId: Int = this.intent.getIntExtra(Constant.ARGUMENT_GENRE_ID, 0)
            val discoveredMovieBasedGenrePagingRecyclerViewFragment = this.supportFragmentManager.findFragmentById(
                it.fragmentContainerViewDiscoveredMovieBasedGenre.id
            ) as DiscoveredMovieBasedGenrePagingRecyclerViewFragment
            discoveredMovieBasedGenrePagingRecyclerViewFragment.arguments = Bundle().also { bundle ->
                bundle.putInt(Constant.ARGUMENT_GENRE_ID, genreId)
            }
        }
    }

    override fun onGetActivityConfiguration(): ActivityConfiguration {
        return super.onGetActivityConfiguration().copy(titleResId = R.string.title_discover_movie)
    }

    override fun onGetViewBinding(): ActivityDiscoveredMovieBasedGenreBinding {
        return ActivityDiscoveredMovieBasedGenreBinding.inflate(this.layoutInflater)
    }
}