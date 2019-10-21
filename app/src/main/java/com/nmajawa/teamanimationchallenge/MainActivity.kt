package com.nmajawa.teamanimationchallenge

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.nmajawa.teamanimationchallenge.transformers.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageArray = intArrayOf(
            R.drawable.first, R.drawable.second,
            R.drawable.third, R.drawable.fourth, R.drawable.fifth
        )

        val adapter = ViewPagerAdapter(this@MainActivity, imageArray)
        viewPager!!.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        when (id) {

            R.id.zoom_out       -> setPageTransformer(ZoomOutTransformation())

        }
        when (id) {

            R.id.depth_page       -> setPageTransformer(DepthPageTransformation())
        }
		when (id) {

            R.id.vertical_flip       -> setPageTransformer(VerticalFlipTransformation())

        }

        return super.onOptionsItemSelected(item)
    }

    private fun setPageTransformer(transformer: ViewPager.PageTransformer ) {
        viewPager!!.setPageTransformer(true, transformer)
    }
}
