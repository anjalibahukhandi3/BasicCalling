package com.intern.callingapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ActiveCallViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: ActiveCallViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = ActiveCallViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testInitialDurationIsZero() = runTest {
        assertEquals("00:00", viewModel.callDuration.value)
    }

    @Test
    fun testTimerIncrements() = runTest {
        // Advance time by 2 seconds
        advanceTimeBy(2000)
        assertEquals("00:02", viewModel.callDuration.value)
    }

    @Test
    fun testToggleMute() {
        assertEquals(false, viewModel.isMuted.value)
        viewModel.toggleMute()
        assertEquals(true, viewModel.isMuted.value)
    }

    @Test
    fun testToggleSpeaker() {
        assertEquals(false, viewModel.isSpeakerOn.value)
        viewModel.toggleSpeaker()
        assertEquals(true, viewModel.isSpeakerOn.value)
    }
}
