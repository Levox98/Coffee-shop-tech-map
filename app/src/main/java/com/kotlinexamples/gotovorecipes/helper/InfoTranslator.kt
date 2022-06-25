package com.kotlinexamples.gotovorecipes.helper

import android.content.res.Resources
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.kotlinexamples.gotovorecipes.R
import com.kotlinexamples.gotovorecipes.adapters.ContentAdapter
import com.kotlinexamples.gotovorecipes.data.ListItem

class InfoTranslator : AppCompatActivity() {

    fun onMenuItemActivated(resources: Resources, adapter: ContentAdapter?,
                            recyclerView: RecyclerView?, drawerLayout: DrawerLayout?, imageArray: Int,
                            namesArray: Int, ingredientsArray: Int, recipesArray: Int) {
        adapter?.updateAdapter(
            fillInfo(
                getImageId(imageArray),
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
                         recipeArray: Array<String>): List<ListItem> {
        val listItemArray = ArrayList<ListItem>()

        for (i in titleArray.indices) {
            val listItem = ListItem(imageArray[i], titleArray[i], ingredientsArray[i], recipeArray[i])
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