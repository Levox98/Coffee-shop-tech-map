package com.kotlinexamples.gotovorecipes

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.kotlinexamples.gotovorecipes.adapters.ContentAdapter
import com.kotlinexamples.gotovorecipes.data.ListItem
import com.kotlinexamples.gotovorecipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private var adapter: ContentAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idNavigationView.setNavigationItemSelectedListener(this)

        drawerLayout = binding.drawerLayout
        drawerLayout?.openDrawer(Gravity.LEFT)

        recyclerView = binding.idLayoutMain.idConstraintLayoutMain
            .findViewById(R.id.id_recycler_view_main)

        val list = ArrayList<ListItem>()

        list.addAll(fillInfo(getImageId(R.array.coffeeImages),
            resources.getStringArray(R.array.coffeeNames),
            resources.getStringArray(R.array.coffeeIngredients),
            resources.getStringArray(R.array.coffeeRecipes)))

        recyclerView?.hasFixedSize()
        recyclerView?.layoutManager = LinearLayoutManager(this)
        adapter = ContentAdapter(list, this)
        recyclerView?.adapter = adapter


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_category_coffee -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.coffeeImages),
                    resources.getStringArray(R.array.coffeeNames),
                    resources.getStringArray(R.array.coffeeIngredients),
                    resources.getStringArray(R.array.coffeeRecipes)))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
            R.id.id_category_tea -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.teaImages),
                    resources.getStringArray(R.array.teaNames),
                    resources.getStringArray(R.array.teaIngredients),
                    resources.getStringArray(R.array.teaRecipes)))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
            R.id.id_category_cocoa -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.cocoaImages),
                    resources.getStringArray(R.array.cocoaNames),
                    resources.getStringArray(R.array.cocoaIngredients),
                    resources.getStringArray(R.array.cocoaRecipes)))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
            R.id.id_category_cold_drink -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.cdImages),
                    resources.getStringArray(R.array.cdNames),
                    resources.getStringArray(R.array.cdIngredients),
                    resources.getStringArray(R.array.cdRecipes)))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
            R.id.id_category_smoothie -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.smoothieImages),
                    resources.getStringArray(R.array.smoothieNames),
                    resources.getStringArray(R.array.smoothieIngredients),
                    resources.getStringArray(R.array.smoothieRecipes)))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
            R.id.id_category_fresh -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.freshImages),
                    resources.getStringArray(R.array.freshNames),
                    resources.getStringArray(R.array.freshIngredients),
                    resources.getStringArray(R.array.freshRecipes)))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
            R.id.id_category_milkshake -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.milkshakeImages),
                    resources.getStringArray(R.array.milkshakeNames),
                    resources.getStringArray(R.array.milkshakeIngredients),
                    resources.getStringArray(R.array.milkshakeRecipes)))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
            R.id.id_category_mulled_wine -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.glyntweinImages),
                    resources.getStringArray(R.array.glyntweinNames),
                    resources.getStringArray(R.array.glyntweinIngredients),
                    resources.getStringArray(R.array.glyntweinRecipes)))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
            R.id.id_category_author_drink -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.adImages),
                    resources.getStringArray(R.array.adNames),
                    resources.getStringArray(R.array.adIngredients),
                    resources.getStringArray(R.array.adRecipes )))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
            R.id.id_category_season_summer -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.sdImages),
                    resources.getStringArray(R.array.sdNames),
                    resources.getStringArray(R.array.sdIngredients),
                    resources.getStringArray(R.array.sdRecipes)))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
            R.id.id_category_season_winter -> {
                adapter?.updateAdapter(fillInfo(getImageId(R.array.wdImages),
                    resources.getStringArray(R.array.wdNames),
                    resources.getStringArray(R.array.wdIngredients),
                    resources.getStringArray(R.array.wdRecipes)))
                recyclerView?.layoutManager?.scrollToPosition(0)
                drawerLayout?.closeDrawer(Gravity.LEFT, true)
            }
        }
        return true
    }

    private fun fillInfo(imageArray: IntArray, titleArray: Array<String>,
                         ingredientsArray: Array<String>,
                         recipeArray: Array<String>): List<ListItem> {
        val listItemArray = ArrayList<ListItem>()

        for (i in titleArray.indices) {
            val listItem = ListItem(imageArray[i], titleArray[i], ingredientsArray[i], recipeArray[i])
            listItemArray.add(listItem)
        }

        return listItemArray
    }

    private fun getImageId(imageArrayId: Int): IntArray {
        val typedArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = typedArray.length()
        val ids = IntArray(count)

        for (i in ids.indices) {
            ids[i] = typedArray.getResourceId(i, 0)
        }

        typedArray.recycle()
        return ids
    }

}