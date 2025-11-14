package com.example.shoppingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MyCartActivity : AppCompatActivity() {

    private var quantity = 1
    private var productPrice = 0
    private var totalPrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)


        productPrice = intent.getIntExtra("PRODUCT_PRICE", 120)
        totalPrice = productPrice

        setupViews()
        updateDisplay()
    }

    private fun setupViews() {
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        val btnMinus = findViewById<Button>(R.id.btnMinus)
        val btnPlaceOrder = findViewById<Button>(R.id.btnPlaceOrder)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnPlus.setOnClickListener {
            quantity++
            calculateTotal()
            updateDisplay()
        }

        btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                calculateTotal()
                updateDisplay()
            }
        }

        btnPlaceOrder.setOnClickListener {
            val intent = Intent(this, SuccessActivity::class.java) //
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun calculateTotal() {
        totalPrice = productPrice * quantity
    }

    private fun updateDisplay() {
        val tvQuantity = findViewById<TextView>(R.id.tvQuantity)
        val tvProductPrice = findViewById<TextView>(R.id.tvProductPrice)
        val tvTotalPrice = findViewById<TextView>(R.id.tvTotalPrice)

        tvQuantity.text = quantity.toString()
        tvProductPrice.text = "$$productPrice"
        tvTotalPrice.text = "Total: $${totalPrice}"
    }
}