package com.kotlinexamples.gotovorecipes


import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.kotlinexamples.gotovorecipes.adapters.ContentAdapter
import com.kotlinexamples.gotovorecipes.data.Item
import com.kotlinexamples.gotovorecipes.databinding.ActivityMainBinding
import com.kotlinexamples.gotovorecipes.helper.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private var adapter: ContentAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var drawerLayout: DrawerLayout? = null

    private var backPressed: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!isStartedFromIntent()) {
            onLaunch()
        } else {
            when (intent.getStringExtra(getString(R.string.which_drink))) {
                R.string.coffee_chosen.toString() -> onRelaunch(resources, R.array.coffeeImages,
                    R.array.coffeeNames, R.array.coffeeIngredients, R.array.coffeeRecipes)

                R.string.tea_chosen.toString() -> onRelaunch(resources, R.array.teaImages,
                    R.array.teaNames, R.array.teaIngredients, R.array.teaRecipes)

                R.string.cocoa_chosen.toString()-> onRelaunch(resources, R.array.cocoaImages,
                    R.array.cocoaNames, R.array.cocoaIngredients, R.array.cocoaRecipes)

                R.string.cold_drink_chosen.toString() -> onRelaunch(resources, R.array.cdImages,
                    R.array.cdNames, R.array.cdIngredients, R.array.cdIngredients)

                R.string.smoothie_chosen.toString() -> onRelaunch(resources, R.array.smoothieImages,
                    R.array.smoothieNames, R.array.smoothieIngredients, R.array.smoothieRecipes)

                R.string.fresh_chosen.toString() -> onRelaunch(resources, R.array.freshImages,
                    R.array.freshNames, R.array.freshIngredients, R.array.freshRecipes)

                R.string.milkshake_chosen.toString() -> onRelaunch(resources, R.array.milkshakeImages,
                    R.array.milkshakeNames, R.array.milkshakeIngredients, R.array.milkshakeRecipes)

                R.string.mulled_wine_chosen.toString() -> onRelaunch(resources, R.array.mulledWineImages,
                    R.array.mulledWineNames, R.array.mulledWineIngredients, R.array.mulledWineRecipes)

                R.string.author_drink_chosen.toString() -> onRelaunch(resources, R.array.adImages,
                    R.array.adNames, R.array.adIngredients, R.array.adIngredients)

                R.string.summer_drink_chosen.toString() -> onRelaunch(resources, R.array.sdImages,
                    R.array.sdNames, R.array.sdIngredients, R.array.sdRecipes)

                R.string.winter_drink_chosen.toString() -> onRelaunch(resources, R.array.wdImages,
                    R.array.wdNames, R.array.wdIngredients, R.array.wdRecipes)
            }
        }

        binding.layoutMain.btnCoffee.setOnClickListener { onRelaunch(resources, R.array.coffeeImages,
            R.array.coffeeNames, R.array.coffeeIngredients, R.array.coffeeRecipes) }

        binding.layoutMain.btnTea.setOnClickListener { onRelaunch(resources, R.array.teaImages,
            R.array.teaNames, R.array.teaIngredients, R.array.teaRecipes) }

        binding.layoutMain.btnCocoa.setOnClickListener { onRelaunch(resources, R.array.cocoaImages,
            R.array.cocoaNames, R.array.cocoaIngredients, R.array.cocoaRecipes) }

        binding.layoutMain.btnColdDrinks.setOnClickListener { onRelaunch(resources, R.array.cdImages,
            R.array.cdNames, R.array.cdIngredients, R.array.cdRecipes) }

        binding.layoutMain.btnSmoothie.setOnClickListener { onRelaunch(resources, R.array.smoothieImages,
            R.array.smoothieNames, R.array.smoothieIngredients, R.array.smoothieRecipes) }

        binding.layoutMain.btnFresh.setOnClickListener { onRelaunch(resources, R.array.freshImages,
            R.array.freshNames, R.array.freshIngredients, R.array.freshRecipes) }

        binding.layoutMain.btnMilkshake.setOnClickListener { onRelaunch(resources, R.array.milkshakeImages,
            R.array.milkshakeNames, R.array.milkshakeIngredients, R.array.milkshakeRecipes) }

        binding.layoutMain.btnMulledWine.setOnClickListener { onRelaunch(resources, R.array.mulledWineImages,
                R.array.mulledWineNames, R.array.mulledWineIngredients, R.array.mulledWineRecipes) }

        binding.layoutMain.btnAuthorDrinks.setOnClickListener { onRelaunch(resources, R.array.adImages,
            R.array.adNames, R.array.adIngredients, R.array.adRecipes) }

        binding.layoutMain.btnSummerDrinks.setOnClickListener { onRelaunch(resources, R.array.sdImages,
            R.array.sdNames, R.array.sdIngredients, R.array.sdRecipes) }

        binding.layoutMain.btnWinterDrinks.setOnClickListener { onRelaunch(resources, R.array.wdImages,
            R.array.wdNames, R.array.wdIngredients, R.array.wdRecipes) }
    }

    override fun onBackPressed() {
        if (backPressed + 1000 > System.currentTimeMillis()) {
            super.onBackPressed()
        } else {
            Toast.makeText(baseContext, resources.getString(R.string.on_back_press_message),
                Toast.LENGTH_SHORT).show()
        }
        backPressed = System.currentTimeMillis()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.category_coffee -> onCoffeeSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.category_tea -> onTeaSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.category_cocoa -> onCocoaSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.category_cold_drink -> onColdDrinkSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.category_smoothie -> onSmoothieSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.category_fresh -> onFreshSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.category_milkshake -> onMilkshakeSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.category_mulled_wine -> onMulledWineSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.category_author_drink -> onAuthorDrinksSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.category_season_summer -> onSummerDrinksSelected(resources, adapter, recyclerView, drawerLayout)
            R.id.category_season_winter -> onWinterDrinksSelected(resources, adapter, recyclerView, drawerLayout)
        }
        return true
    }

    private fun onLaunch() {

        binding.idNavigationView.setNavigationItemSelectedListener(this)

        drawerLayout = binding.drawerLayout
        drawerLayout?.openDrawer(GravityCompat.START)

        recyclerView = binding.layoutMain.constraintLayoutMain
            .findViewById(R.id.id_recycler_view_main)

        recyclerView?.hasFixedSize()
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val list = ArrayList<Item>()

        list.addAll(fillInfo(getImageId(resources, R.array.coffeeImages),
            resources.getStringArray(R.array.coffeeNames),
            resources.getStringArray(R.array.coffeeIngredients),
            resources.getStringArray(R.array.coffeeRecipes)))

        adapter = ContentAdapter(list, this)

        recyclerView?.adapter = adapter
    }

    private fun onRelaunch(resources: Resources, imagesArray: Int, namesArray: Int,
                           ingredientsArray: Int, recipesArray: Int) {

        binding.idNavigationView.setNavigationItemSelectedListener(this)

        drawerLayout = binding.drawerLayout

        recyclerView = binding.layoutMain.constraintLayoutMain
            .findViewById(R.id.id_recycler_view_main)

        recyclerView?.hasFixedSize()
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val list = ArrayList<Item>()

        list.addAll(fillInfo(getImageId(resources, imagesArray),
            resources.getStringArray(namesArray),
            resources.getStringArray(ingredientsArray),
            resources.getStringArray(recipesArray)))

        adapter = ContentAdapter(list, this)

        recyclerView?.adapter = adapter
    }

    private fun isStartedFromIntent(): Boolean {
        val i: Intent = intent

        return i.getIntExtra(getString(R.string.starting_from_intent), 0) != 0
    }
}