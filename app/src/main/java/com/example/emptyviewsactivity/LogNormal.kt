package com.example.emptyviewsactivity

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.ln
import kotlin.math.sqrt
import kotlin.random.Random

object LogNormal {
    fun generate(
        mu: Double,
        sigmaSquared: Double,
    ): Double {
        if (sigmaSquared < 0) {
            return Double.NaN
        }

        val sigma = sqrt(sigmaSquared)

        val u1 = Random.nextDouble()
        val u2 = Random.nextDouble()

        val z0 = sqrt(-2.0 * ln(u1)) * cos(2.0 * PI * u2)

        return exp(mu + sigma * z0)
    }
}
