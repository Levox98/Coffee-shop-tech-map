package com.kotlinexamples.gotovorecipes.data

interface Image {
    abstract val imageId: Int
}

interface Name {
    abstract val name: String
    abstract val volume: Int
}

interface Ingredients {
    abstract val ingredients: Array<String>
}

interface Recipe {
    abstract val recipeText: String
}