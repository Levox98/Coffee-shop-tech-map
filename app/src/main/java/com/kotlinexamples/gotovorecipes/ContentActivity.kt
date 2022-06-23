package com.kotlinexamples.gotovorecipes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlinexamples.gotovorecipes.databinding.FullContentLayoutBinding

class ContentActivity : AppCompatActivity() {

    lateinit var binding: FullContentLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FullContentLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.idContentMainImage.setImageResource(intent.getIntExtra("image", R.drawable.ic_coffee))
        binding.idContentName.text = intent.getStringExtra("title")
        binding.idTvIngredients.text = intent.getStringExtra("ingredients")
        binding.idContentRecipe.text = intent.getStringExtra("recipe")
    }
}