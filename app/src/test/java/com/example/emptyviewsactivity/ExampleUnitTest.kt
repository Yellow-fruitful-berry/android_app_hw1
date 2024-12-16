package com.example.emptyviewsactivity

import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.math.abs

class ExampleUnitTest {
    @Test
    fun testGenerateLogNormal_withValidParameters() {
        val mu = 0.0
        val sigmaSquared = 1.0

        val result = LogNormal.generate(mu, sigmaSquared)

        assertTrue(result > 0)
    }

    @Test
    fun testGenerateLogNormal_withZeroVariance() {
        val mu = 0.0
        val sigmaSquared = 0.0

        val result = LogNormal.generate(mu, sigmaSquared)

        assertTrue(abs(result - 1.0) < 1e-6)
    }

    @Test
    fun testGenerateLogNormal_withNegativeVariance() {
        val mu = 0.0
        val sigmaSquared = -1.0

        val result = LogNormal.generate(mu, sigmaSquared)

        assertTrue(result.isNaN())
    }
}
