package com.kotlinexamples.gotovorecipes.helper

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlinexamples.gotovorecipes.R
import com.kotlinexamples.gotovorecipes.adapters.ContentAdapter
import com.kotlinexamples.gotovorecipes.data.ListItem
import com.kotlinexamples.gotovorecipes.databinding.ActivityMainBinding

/*
fun onCoffeeChosen(binding: ActivityMainBinding, recyclerView: RecyclerView) {

    binding.idNavigationView.setNavigationItemSelectedListener(this)

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

 */