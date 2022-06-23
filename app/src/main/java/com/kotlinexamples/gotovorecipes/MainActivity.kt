package com.kotlinexamples.gotovorecipes

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.kotlinexamples.gotovorecipes.adapters.ContentAdapter
import com.kotlinexamples.gotovorecipes.data.ListItem
import com.kotlinexamples.gotovorecipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityMainBinding

    var adapter: ContentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idNavigationView.setNavigationItemSelectedListener(this)

        val recyclerView: RecyclerView = binding.idLayoutMain.idConstraintLayoutMain
            .findViewById(R.id.id_recycler_view_main)

        val list = ArrayList<ListItem>()

        list.addAll(fillInfo(getImageId(R.array.coffeeImages),
            resources.getStringArray(R.array.coffeeNames),
            resources.getStringArray(R.array.coffeeIngredients),
            resources.getStringArray(R.array.coffeeRecipes)))

        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ContentAdapter(list, this)
        recyclerView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_category_coffee -> {
                Toast.makeText(this, "COFFEE", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillInfo(getImageId(R.array.coffeeImages),
                    resources.getStringArray(R.array.coffeeNames),
                    resources.getStringArray(R.array.coffeeIngredients),
                    resources.getStringArray(R.array.coffeeRecipes)))
            }
            R.id.id_category_tea -> {
                Toast.makeText(this, "TEA", Toast.LENGTH_SHORT).show()
            }
            R.id.id_category_cocoa -> {
                Toast.makeText(this, "COCOA", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillInfo(getImageId(R.array.cocoaImages),
                    resources.getStringArray(R.array.cocoaNames),
                    resources.getStringArray(R.array.cocoaIngredients),
                    resources.getStringArray(R.array.cocoaRecipes)))
            }
            R.id.id_category_cold_drink -> Toast.makeText(this, "COLD DRINK",
                Toast.LENGTH_SHORT).show()
            R.id.id_category_smoothie -> Toast.makeText(this, "SMOOTHIE",
                Toast.LENGTH_SHORT).show()
            R.id.id_category_fresh -> Toast.makeText(this, "FRESH",
                Toast.LENGTH_SHORT).show()
            R.id.id_category_milkshake -> Toast.makeText(this, "MILKSHAKE",
                Toast.LENGTH_SHORT).show()
            R.id.id_category_mulled_wine -> Toast.makeText(this, "GLYNTWEIN",
                Toast.LENGTH_SHORT).show()
            R.id.id_category_author_drink -> Toast.makeText(this, "AUTHOR",
                Toast.LENGTH_SHORT).show()
        }
        return true
    }

    fun fillInfo(imageArray: IntArray, titleArray: Array<String>,
                 ingredientsArray: Array<String>,
                 recipeArray: Array<String>): List<ListItem> {
        val listItemArray = ArrayList<ListItem>()

        for (i in titleArray.indices) {
            var listItem = ListItem(imageArray[i], titleArray[i], ingredientsArray[i], recipeArray[i])
            listItemArray.add(listItem)
        }

        return listItemArray
    }

    fun getImageId(imageArrayId: Int): IntArray {
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