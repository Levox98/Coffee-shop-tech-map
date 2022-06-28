package com.kotlinexamples.gotovorecipes.helper

import android.content.res.Resources
import android.content.res.TypedArray
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.kotlinexamples.gotovorecipes.R
import com.kotlinexamples.gotovorecipes.adapters.ContentAdapter
import com.kotlinexamples.gotovorecipes.data.Item

fun onCoffeeSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                     drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.coffeeImages,
        R.array.coffeeNames, R.array.coffeeIngredients, R.array.coffeeRecipes)
}

fun onTeaSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                     drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.teaImages,
        R.array.teaNames, R.array.teaIngredients, R.array.teaRecipes)
}

fun onCocoaSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                     drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.cocoaImages,
        R.array.cocoaNames, R.array.cocoaIngredients, R.array.cocoaRecipes)
}

fun onColdDrinkSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                  drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.cdImages,
        R.array.cdNames, R.array.cdIngredients, R.array.cdRecipes)
}

fun onSmoothieSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                     drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.smoothieImages,
        R.array.smoothieNames, R.array.smoothieIngredients, R.array.smoothieRecipes)
}

fun onFreshSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                  drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.freshImages,
        R.array.freshNames, R.array.freshIngredients, R.array.freshRecipes)
}

fun onMilkshakeSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                    drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.milkshakeImages,
        R.array.milkshakeNames, R.array.milkshakeIngredients, R.array.milkshakeRecipes)
}

fun onMulledWineSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                        drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.mulledWineImages,
        R.array.mulledWineNames, R.array.mulledWineIngredients, R.array.mulledWineRecipes)
}

fun onAuthorDrinksSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                    drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.adImages,
        R.array.adNames, R.array.adIngredients, R.array.adRecipes)
}

fun onSummerDrinksSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                        drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.sdImages,
        R.array.sdNames, R.array.sdIngredients, R.array.sdRecipes)
}

fun onWinterDrinksSelected(resources: Resources, adapter: ContentAdapter?, recyclerView: RecyclerView?,
                         drawerLayout: DrawerLayout?) {
    onMenuItemActivated(resources, adapter, recyclerView, drawerLayout, R.array.wdImages,
        R.array.wdNames, R.array.wdIngredients, R.array.wdRecipes)
}

fun onMenuItemActivated(resources: Resources, adapter: ContentAdapter?,
                        recyclerView: RecyclerView?, drawerLayout: DrawerLayout?, imageArray: Int,
                        namesArray: Int, ingredientsArray: Int, recipesArray: Int) {
    adapter?.updateAdapter(
        fillInfo(
            getImageId(resources, imageArray),
            resources.getStringArray(namesArray),
            resources.getStringArray(ingredientsArray),
            resources.getStringArray(recipesArray)
        )
    )

    recyclerView?.layoutManager?.scrollToPosition(0)
    drawerLayout?.closeDrawer(GravityCompat.START, true)
}

fun fillInfo(imageArray: IntArray, titleArray: Array<String>,
             ingredientsArray: Array<String>,
             recipeArray: Array<String>): List<Item> {
    val itemArray = ArrayList<Item>()

    for (i in titleArray.indices) {
        val item = Item(imageArray[i], titleArray[i], ingredientsArray[i], recipeArray[i])
        itemArray.add(item)
    }

    return itemArray
}

fun getImageId(resources: Resources, imageArrayId: Int): IntArray {
    val typedArray: TypedArray = resources.obtainTypedArray(imageArrayId)
    val count = typedArray.length()
    val ids = IntArray(count)

    for (i in ids.indices) {
        ids[i] = typedArray.getResourceId(i, 0)
    }

    typedArray.recycle()
    return ids
}