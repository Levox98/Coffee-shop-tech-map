package com.kotlinexamples.gotovorecipes.data.drinks.attributes

import android.content.Context
import com.kotlinexamples.gotovorecipes.R


enum class CoffeeIngredients(override val ingredients: Array<Int>) : Ingredients {
    AMERICANO_SMALL(arrayOf(
        R.string.green_cup, R.string.base_dopio,
        R.string.water
    )),
    AMERICANO_BIG(arrayOf(
        R.string.black_cup, R.string.base_triplo,
        R.string.water
    )),
    CAPPUCCINO_SMALL(arrayOf(
        R.string.yellow_cup, R.string.base_dopio,
        R.string.milk
    )),
    CAPPUCCINO_BIG(arrayOf(
        R.string.black_cup, R.string.base_triplo,
        R.string.milk
    ));

    fun toActualText(context: Context): String {
        var string: String = ""

        this.ingredients.forEach {
            string += if (it != ingredients.last()) {
                "${context.resources.getString(it)}, "
            } else {
                "${context.resources.getString(it)}."
            }
        }

        return string
    }
}