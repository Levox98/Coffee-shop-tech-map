package com.kotlinexamples.gotovorecipes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.kotlinexamples.gotovorecipes.adapters.ContentAdapter
import com.kotlinexamples.gotovorecipes.databinding.ContentLayoutBinding

class ContentActivity : AppCompatActivity() {

    lateinit var binding: ContentLayoutBinding

    private var adapter: ContentAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var drawerLayout: DrawerLayout? = null

    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idFullContent.idContentMainImage.setImageResource(intent.getIntExtra("image", R.drawable.ic_coffee))
        binding.idFullContent.idContentName.text = intent.getStringExtra("title")
        binding.idFullContent.idTvIngredients.text = intent.getStringExtra("ingredients")
        binding.idFullContent.idContentRecipe.text = intent.getStringExtra("recipe")
    }
}