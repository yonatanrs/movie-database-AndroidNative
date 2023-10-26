package com.yonatanrs.moviedatabase.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.yonatanrs.moviedatabase.R
import com.yonatanrs.moviedatabase.core.misc.ActivityConfiguration
import com.yonatanrs.moviedatabase.core.presentation.BaseActivity
import com.yonatanrs.moviedatabase.databinding.ActivityMainBinding
import com.yonatanrs.moviedatabase.presentation.misc.bottomnavcomponent.BottomNavManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>() {
    private var bottomNavManager: BottomNavManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTheme(R.style.Theme_MovieDatabase)
        super.onCreate(savedInstanceState)
        viewBinding?.also {
            setupNavigationManager(it)
        }
    }

    private fun setupNavigationManager(activityMainBinding: ActivityMainBinding) {
        bottomNavManager?.setupNavController() ?: this.run {
            bottomNavManager = BottomNavManager(
                fragmentManager = this.supportFragmentManager,
                containerId = activityMainBinding.fragmentNavHost.id,
                bottomNavigationView = activityMainBinding.bottomNavigationViewNavHost,
                navGraphIds = listOf(
                    R.navigation.nav_graph_popular_movie,
                    R.navigation.nav_graph_movie_genre,
                    R.navigation.nav_graph_top_rated_movie,
                    R.navigation.nav_graph_upcoming_movie,
                ),
                firstBottomNavigationItemId = R.id.nav_graph_popular_movie
            )
        }
    }

    override fun onGetActivityConfiguration(): ActivityConfiguration {
        return super.onGetActivityConfiguration().copy(supportBack = false)
    }

    override fun onGetViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(this.layoutInflater)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.item_search_movie -> this.startActivity(Intent(this, SearchMovieActivity::class.java)).let { true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        bottomNavManager?.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        bottomNavManager?.onRestoreInstanceState(savedInstanceState)
        viewBinding?.also {
            setupNavigationManager(it)
        }
    }

    override fun onBackPressed() {
        if (bottomNavManager?.onBackPressed() == false) {
            super.onBackPressed()
        }
    }
}