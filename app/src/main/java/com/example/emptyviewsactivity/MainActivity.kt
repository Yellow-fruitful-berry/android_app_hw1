package com.example.emptyviewsactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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

            if (mu == null || sigmaSquared == null || mu.isNaN() || sigmaSquared.isNaN()) {
                resultView.text = getString(R.string.invalid_input_message)
                return@setOnClickListener
            }

            if (sigmaSquared < 0) {
                resultView.text = getString(R.string.negative_variance_message)
                return@setOnClickListener
            }

            generatedNumber = LogNormal.generate(mu, sigmaSquared) // Updated call
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
}
