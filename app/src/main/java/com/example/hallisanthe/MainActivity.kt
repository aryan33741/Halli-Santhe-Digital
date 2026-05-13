package com.example.hallisanthe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hallisanthe.adapter.ProductAdapter
import com.example.hallisanthe.model.Product

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    private lateinit var productList: ArrayList<Product>
    private lateinit var filteredList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val searchView = findViewById<SearchView>(R.id.searchView)

        val addButton = findViewById<Button>(R.id.addProductBtn)

        productList = arrayListOf(

            Product(
                "Channapatna Toy",
                "500",
                R.drawable.toy,
                "Traditional handmade wooden toy"
            ),

            Product(
                "Clay Pot",
                "300",
                R.drawable.clay,
                "Eco-friendly clay pot"
            ),

            Product(
                "Handmade Bag",
                "700",
                R.drawable.bag,
                "Village handmade bag"
            ),

            Product(
                "Bamboo Basket",
                "450",
                R.drawable.basket,
                "Strong bamboo basket"
            )
        )

        filteredList = ArrayList(productList)

        adapter = ProductAdapter(filteredList)

        recyclerView.layoutManager = GridLayoutManager(this, 2)

        recyclerView.adapter = adapter

        addButton.setOnClickListener {

            startActivity(
                Intent(this, UploadProductActivity::class.java)
            )
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                filteredList.clear()

                if (newText.isNullOrEmpty()) {

                    filteredList.addAll(productList)

                } else {

                    for (product in productList) {

                        if (product.name.lowercase()
                                .contains(newText.lowercase())
                        ) {

                            filteredList.add(product)
                        }
                    }
                }

                adapter.notifyDataSetChanged()

                return true
            }
        })
    }
}