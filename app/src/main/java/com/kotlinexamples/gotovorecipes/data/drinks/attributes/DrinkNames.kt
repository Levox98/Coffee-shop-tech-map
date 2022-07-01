package com.kotlinexamples.gotovorecipes.data.drinks.attributes

import android.content.Context
import com.kotlinexamples.gotovorecipes.R


enum class CoffeeNames(
    override val drinkName: Int,
    override val volume: Int
) : Name {
    AMERICANO_SMALL(R.string.americano, R.integer.vol250),
    AMERICANO_BIG(R.string.americano, R.integer.vol400),
    CAPPUCCINO_SMALL(R.string.cappuccino, R.integer.vol350),
    CAPPUCCINO_BIG(R.string.cappuccino, R.integer.vol500),
    LATTE_SMALL(R.string.latte, R.integer.vol350),
    LATTE_BIG(R.string.latte, R.integer.vol500),
    ROUGH_SMALL(R.string.rough, R.integer.vol350),
    ROUGH_BIG(R.string.rough, R.integer.vol500),
    FLAT_WHITE_SMALL(R.string.flat_white, R.integer.vol250),
    FLAT_WHITE_BIG(R.string.flat_white, R.integer.vol350);

    fun toActualText(context: Context): String {
        return "${context.resources.getString(this.drinkName)} ${context.resources.getString(this.volume)}"
    }
}