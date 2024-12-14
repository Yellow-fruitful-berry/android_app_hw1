package com.example.emptyviewsactivity

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.sqrt
import kotlin.math.abs
import kotlin.random.Random


class ExampleUnitTest {
    @Test
    fun generateLogNormalTest1() {
        val mu = 1.0
        val sigmaSquared = 2.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result > 0)
    }

    @Test
    fun generateLogNormalTest2() {
        val mu = Double.NaN
        val sigmaSquared = 1.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result.isNaN())
    }

    @Test
    fun generateLogNormalTest3() {
        val mu = 0.0
        val sigmaSquared = 0.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result == 1.0)
    }

    @Test
    fun generateLogNormalTest4() {
        val mu = Double.NaN
        val sigmaSquared = Double.NaN
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result.isNaN())
    }

    @Test
    fun generateLogNormalTest5() {
        val mu = 1.0
        val sigmaSquared = -1.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result.isNaN())
    }

    @Test
    fun generateLogNormalTest6() {
        val mu = 1.0
        val sigmaSquared = -1.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result.isNaN())
    }

    @Test
    fun generateLogNormalTest7() {
        val mu = 1.0
        val sigmaSquared = -1.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        assertTrue(result.isNaN())
    }

    @Test
    fun generateLogNormalTest8() {
        val mu = 1.0
        val sigmaSquared = 0.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        val eps = 1e-9
        assertTrue(abs(result - 2.718281828459045) < eps)
    }

    @Test
    fun generateLogNormalTest9() {
        val mu = 1/(2.0 * PI)
        val sigmaSquared = 0.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        val eps = 1e-9
        assertTrue(abs(result - 1.172519606429523) < eps)
    }

    @Test
    fun generateLogNormalTest10() {
        val mu = 2.0
        val sigmaSquared = 0.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        val eps = 1e-9
        assertTrue(abs(result - 7.3890560989065) < eps)
    }

    @Test
    fun generateLogNormalTest11() {
        val mu = -2.0
        val sigmaSquared = 0.0
        val sigma = sqrt(sigmaSquared)
        val z = Random.nextDouble()
        val result = exp(mu + sigma * z)
        val eps = 1e-9
        assertTrue(abs(result - 0.1353352832366127) < eps)
    }
}