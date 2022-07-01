package com.kotlinexamples.gotovorecipes.data.drinks.attributes


interface Name {
    val drinkName: Int
    val volume: Int

    fun returnFullName(): String {
        return "$drinkName ${volume}мл"
    }
}

interface Ingredients {
    val ingredients: Array<Int>
}