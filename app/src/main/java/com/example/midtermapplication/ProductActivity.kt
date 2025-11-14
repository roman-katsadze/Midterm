package com.example.shoppingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProductActivity : AppCompatActivity() {

    private val productPrice = 120

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val btnAddToCart = findViewById<Button>(R.id.btnAddToCart)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnAddToCart.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            intent.putExtra("PRODUCT_PRICE", productPrice)
            startActivity(intent)
        }

        btnBack?.setOnClickListener {
            finish()
        }
    }
}