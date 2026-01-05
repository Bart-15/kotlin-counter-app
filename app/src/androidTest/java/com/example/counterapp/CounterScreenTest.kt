package com.example.counterapp

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.counterapp.ui.compose.CounterScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun initialCountIsZero() {
        composeTestRule.setContent {
            CounterScreen()
        }

        composeTestRule.onNodeWithTag("countText")
            .assertTextEquals("0")
    }

    @Test
    fun incrementButtonIncrementCount(){
        composeTestRule.setContent {
            CounterScreen()
        }

        val incrementTimes = 3
        repeat(incrementTimes){
            composeTestRule.onNodeWithTag("incrementButton").performClick()
        }


        composeTestRule.onNodeWithTag("countText")
            .assertTextEquals("3")
    }

    @Test
    fun decrementButtonDecrementCount(){
        composeTestRule.setContent {
            CounterScreen()
        }

        val incrementTimes = 3
        repeat(incrementTimes){
            composeTestRule.onNodeWithTag("incrementButton").performClick()
        }

        composeTestRule.onNodeWithTag("decrementButton").performClick()

        composeTestRule.onNodeWithTag("countText")
            .assertTextEquals("2")
    }

    @Test
    fun resetButton(){
        composeTestRule.setContent {
            CounterScreen()
        }

        val incrementTimes = 3
        repeat(incrementTimes){
            composeTestRule.onNodeWithTag("incrementButton").performClick()
        }

        composeTestRule.onNodeWithTag("resetButton").performClick()

        composeTestRule.onNodeWithTag("countText")
            .assertTextEquals("0")

    }
}
