package com.kotlinexamples.gotovorecipes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.kotlinexamples.gotovorecipes.adapters.ContentAdapter
import com.kotlinexamples.gotovorecipes.databinding.ContentLayoutBinding

class ContentActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ContentLayoutBinding

    private var adapter: ContentAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var drawerLayout: DrawerLayout? = null

    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idNavigationView.setNavigationItemSelectedListener(this)

        binding.idFullContent.idContentMainImage.setImageResource(intent.getIntExtra("image", R.drawable.ic_coffee))
        binding.idFullContent.idContentName.text = intent.getStringExtra("title")
        binding.idFullContent.idTvIngredients.text = intent.getStringExtra("ingredients")
        binding.idFullContent.idContentRecipe.text = intent.getStringExtra("recipe")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_category_coffee -> testingStuff(R.string.coffee_chosen.toString())
            R.id.id_category_tea -> testingStuff(R.string.tea_chosen.toString())
            R.id.id_category_cocoa -> testingStuff(R.string.cocoa_chosen.toString())
            R.id.id_category_cold_drink -> testingStuff(R.string.cold_drink_chosen.toString())
            R.id.id_category_smoothie -> testingStuff(R.string.smoothie_chosen.toString())
            R.id.id_category_fresh -> testingStuff(R.string.fresh_chosen.toString())
            R.id.id_category_milkshake -> testingStuff(R.string.milkshake_chosen.toString())
            R.id.id_category_mulled_wine -> testingStuff(R.string.mulled_wine_chosen.toString())
            R.id.id_category_author_drink -> testingStuff(R.string.author_drink_chosen.toString())
            R.id.id_category_season_summer -> testingStuff(R.string.summer_drink_chosen.toString())
            R.id.id_category_season_winter -> testingStuff(R.string.winter_drink_chosen.toString())
        }
        return true
    }

    private fun testingStuff(string: String) {
        val i = Intent(this, MainActivity::class.java).apply {
            putExtra(getString(R.string.which_drink), string)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            putExtra(getString(R.string.starting_from_intent), 1)
        }
        startActivity(i)
        finish()
    }
}