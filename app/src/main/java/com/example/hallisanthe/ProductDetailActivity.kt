package com.example.hallisanthe

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hallisanthe.model.Product

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product_detail)

        val image = findViewById<ImageView>(R.id.detailImage)

        val name = findViewById<TextView>(R.id.detailName)

        val price = findViewById<TextView>(R.id.detailPrice)

        val desc = findViewById<TextView>(R.id.detailDescription)

        val button = findViewById<Button>(R.id.stockButton)

        val product = intent.getSerializableExtra("product") as Product

        image.setImageResource(product.image)

        name.text = product.name

        price.text = "₹${product.price}"

        desc.text = product.description

        button.setOnClickListener {

            Toast.makeText(
                this,
                "Seller will contact you",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}