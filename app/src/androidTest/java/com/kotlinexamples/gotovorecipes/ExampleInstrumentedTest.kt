package com.kotlinexamples.gotovorecipes

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kotlinexamples.gotovorecipes.data.drinks.AmericanoSmall
import com.kotlinexamples.gotovorecipes.data.drinks.Drink
import com.kotlinexamples.gotovorecipes.helper.getCoffeeArray

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.kotlinexamples.gotovorecipes", appContext.packageName)

        val coffeeList = getCoffeeArray(appContext)

        coffeeList.forEach {
            println(it.imageId)
            println(it.name)
            println(it.ingredients)
            println(it.recipe)
        }
    }
}