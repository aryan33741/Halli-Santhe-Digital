package com.example.hallisanthe

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UploadProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_upload_product)

        val name = findViewById<EditText>(R.id.editName)
        val price = findViewById<EditText>(R.id.editPrice)
        val image = findViewById<EditText>(R.id.editImage)
        val desc = findViewById<EditText>(R.id.editDescription)

        val uploadBtn = findViewById<Button>(R.id.uploadBtn)

        uploadBtn.setOnClickListener {

            Toast.makeText(
                this,
                "Product Uploaded Successfully",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}