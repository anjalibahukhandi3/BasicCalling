package com.intern.callingapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DialPadViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DialPadViewModel

    @Before
    fun setup() {
        viewModel = DialPadViewModel()
    }

    @Test
    fun testAppendDigit() {
        viewModel.appendDigit("1")
        viewModel.appendDigit("2")
        viewModel.appendDigit("3")
        assertEquals("123", viewModel.inputNumber.value)
    }

    @Test
    fun testBackspace() {
        viewModel.appendDigit("9")
        viewModel.appendDigit("8")
        viewModel.backspace()
        assertEquals("9", viewModel.inputNumber.value)
    }

    @Test
    fun testClear() {
        viewModel.appendDigit("5")
        viewModel.appendDigit("5")
        viewModel.clear()
        assertEquals("", viewModel.inputNumber.value)
    }
}
