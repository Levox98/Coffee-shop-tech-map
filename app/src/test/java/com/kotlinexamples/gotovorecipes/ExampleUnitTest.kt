package com.kotlinexamples.gotovorecipes

import com.kotlinexamples.gotovorecipes.data.drinks.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun showCoffeeInfo() {
        val arrayListOfCoffee = arrayListOf<Drink>(AmericanoSmall(), AmericanoBig(), CappuccinoSmall(), CappuccinoBig())

        arrayListOfCoffee.forEach {
            println(it.imageId)
            println(it.name)
            println(it.ingredients)
            println(it.recipe)
        }
    }
}