package com.kotlinexamples.gotovorecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlinexamples.gotovorecipes.databinding.ActivityTechInfoBinding

class TechInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityTechInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTechInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}