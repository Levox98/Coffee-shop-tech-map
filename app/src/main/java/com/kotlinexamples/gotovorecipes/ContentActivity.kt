package com.kotlinexamples.gotovorecipes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlinexamples.gotovorecipes.databinding.ContentLayoutBinding
import com.kotlinexamples.gotovorecipes.databinding.FullContentLayoutBinding

class ContentActivity : AppCompatActivity() {

    lateinit var binding: ContentLayoutBinding

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