package com.kotlinexamples.gotovorecipes.data.drinks

import android.content.Context
import com.kotlinexamples.gotovorecipes.R
import com.kotlinexamples.gotovorecipes.data.drinks.attributes.CoffeeIngredients
import com.kotlinexamples.gotovorecipes.data.drinks.attributes.CoffeeNames

class AmericanoSmall(context: Context) : Drink(
    imageId = R.drawable.ic_coffee_general,
    name = CoffeeNames.AMERICANO_SMALL.toActualText(context),
    ingredients = CoffeeIngredients.AMERICANO_SMALL.toActualText(context),
    recipe = context.resources.getString(R.string.americano_small)
)


class AmericanoBig(context: Context) : Drink(
    imageId = R.drawable.ic_coffee_general,
    name = CoffeeNames.AMERICANO_BIG.toActualText(context),
    ingredients = CoffeeIngredients.AMERICANO_BIG.toActualText(context),
    recipe = context.resources.getString(R.string.americano_big)
)

class CappuccinoSmall(context: Context) : Drink(
    imageId = R.drawable.ic_coffee_general,
    name = CoffeeNames.CAPPUCCINO_SMALL.toActualText(context),
    ingredients = CoffeeIngredients.CAPPUCCINO_SMALL.toActualText(context),
    recipe = context.resources.getString(R.string.cappuccino_small)
)

class CappuccinoBig(context: Context) : Drink(
    imageId = R.drawable.ic_coffee_general,
    name = CoffeeNames.CAPPUCCINO_BIG.toActualText(context),
    ingredients = CoffeeIngredients.CAPPUCCINO_BIG.toActualText(context),
    recipe = context.resources.getString(R.string.cappuccino_big)
)
