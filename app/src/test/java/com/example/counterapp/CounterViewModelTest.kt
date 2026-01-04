package com.example.counterapp

import com.example.counterapp.viewmodel.CounterViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class CounterViewModelTest {

    private lateinit var viewModel: CounterViewModel

    @Before
    fun setup(){
        viewModel = CounterViewModel()
    }

    @Test
    fun `initial count should be zero` () {
        assertEquals(0, viewModel.count)
    }

    @Test
    fun `increment should increase count by 1` (){
        viewModel.increment()
        assertEquals(1, viewModel.count)
    }

    @Test
    fun `should not decrement if count is zero` () {
        viewModel.decrement()
        assertEquals(0, viewModel.count)
    }

    @Test
    fun `decrement should decrease count by 1` () {
        viewModel.increment()

        viewModel.decrement()

        assertEquals(0, viewModel.count)
    }

    @Test
    fun `reset should set count back to zero`() {
        viewModel.increment()
        viewModel.increment()
        assertEquals(2, viewModel.count)
        viewModel.reset()
        assertEquals(0, viewModel.count)
    }
}