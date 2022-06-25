package com.kotlinexamples.gotovorecipes


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.kotlinexamples.gotovorecipes.adapters.ContentAdapter
import com.kotlinexamples.gotovorecipes.data.ListItem
import com.kotlinexamples.gotovorecipes.databinding.ActivityMainBinding
import com.kotlinexamples.gotovorecipes.helper.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private var adapter: ContentAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            onLaunch()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_category_coffee -> onCoffeeSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.id_category_tea -> onTeaSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.id_category_cocoa -> onCocoaSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.id_category_cold_drink -> onColdDrinkSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.id_category_smoothie -> onSmoothieSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.id_category_fresh -> onFreshSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.id_category_milkshake -> onMilkshakeSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.id_category_mulled_wine -> onMulledWineSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.id_category_author_drink -> onAuthorDrinksSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.id_category_season_summer -> onSummerDrinksSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.id_category_season_winter -> onWinterDrinksSelected(resources, adapter, recyclerView, drawerLayout)
        }
        return true
    }

    private fun onLaunch() {

        binding.idNavigationView.setNavigationItemSelectedListener(this)

        drawerLayout = binding.drawerLayout
        drawerLayout?.openDrawer(GravityCompat.START)

        recyclerView = binding.idLayoutMain.idConstraintLayoutMain
            .findViewById(R.id.id_recycler_view_main)

        recyclerView?.hasFixedSize()
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val list = ArrayList<ListItem>()

        list.addAll(fillInfo(getImageId(resources, R.array.coffeeImages),
            resources.getStringArray(R.array.coffeeNames),
            resources.getStringArray(R.array.coffeeIngredients),
            resources.getStringArray(R.array.coffeeRecipes)))

        adapter = ContentAdapter(list, this)

        recyclerView?.adapter = adapter
    }
}