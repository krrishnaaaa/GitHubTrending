package com.pcsalt.example.githubtrending

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pcsalt.example.githubtrending.trendinglist.TrendingListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container,
                TrendingListFragment(),
                TrendingListFragment::class.java.simpleName
            )
            .commit()
    }
}