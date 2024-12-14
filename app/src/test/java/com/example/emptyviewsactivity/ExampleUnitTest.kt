package com.example.emptyviewsactivity

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.exp
import kotlin.math.sqrt
import kotlin.random.Random


class ExampleUnitTest {
    @Test
    fun generateLogNormalTest() {
        val mu = 1.0
        val sigmaSquared = 2.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result > 0)
    }

    @Test
    fun generateLogNormalTest1() {
        val mu = 1.0
        val sigmaSquared = 1.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result == 1.0)
    }

    @Test
    fun generateLogNormalTest2() {
        val mu = 1.0
        val sigmaSquared = -1.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result.isNaN())
    }

    @Test
    fun generateLogNormalTest3() {
        val mu = 1.0
        val sigmaSquared = -1.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result.isNaN())
    }

    @Test
    fun generateLogNormalTest4() {
        val mu = 1.0
        val sigmaSquared = -1.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result.isNaN())
    }
}