package com.example.emptyviewsactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.exp
import kotlin.math.sqrt
import kotlin.random.Random
import kotlin.math.ln
import kotlin.math.cos
import kotlin.math.PI

class MainActivity : AppCompatActivity() {
    private var generatedNumber: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meanVal = findViewById<EditText>(R.id.mean_val)
        val varianceVal = findViewById<EditText>(R.id.variance_value)
        val generateButton = findViewById<Button>(R.id.get_random_num)
        val resultView = findViewById<TextView>(R.id.random_number_result)

        generateButton.setOnClickListener {
            val mu = meanVal.text.toString().toDoubleOrNull()
            val sigmaSquared = varianceVal.text.toString().toDoubleOrNull()

            if (mu == null || sigmaSquared == null) {
                resultView.text = "Invalid input. Please enter valid numbers."
                return@setOnClickListener
            }

            if (sigmaSquared < 0) {
                resultView.text = "Variance cannot be negative."
                return@setOnClickListener
            }

            if (mu.isNaN() || sigmaSquared.isNaN()) {
                resultView.text = "Invalid input. Please enter valid numbers."
                return@setOnClickListener
            }

            generatedNumber = generateLogNormal(mu, sigmaSquared)
            resultView.text = generatedNumber.toString()
        }

        if (savedInstanceState != null) {
            generatedNumber = savedInstanceState.getDouble("generatedNumber")
            resultView.text = generatedNumber?.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("generatedNumber", generatedNumber ?: 0.0)
    }

    private fun generateLogNormal(mu: Double, sigmaSquared: Double): Double {
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
