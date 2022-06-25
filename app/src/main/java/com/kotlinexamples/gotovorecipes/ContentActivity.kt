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
            R.id.id_category_coffee -> {
                Toast.makeText(this, "!!!!!!!!", Toast.LENGTH_SHORT).show()

                val i = Intent(this, MainActivity::class.java).apply {
                    putExtra("ImageArray", R.array.coffeeImages)
                    putExtra("NameArray", R.array.coffeeNames)
                    putExtra("IngredientsArray", R.array.coffeeIngredients)
                    putExtra("RecipesArray", R.array.coffeeRecipes)
                }
                startActivity(i)
            }
            else -> Toast.makeText(this, "!!!!", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}