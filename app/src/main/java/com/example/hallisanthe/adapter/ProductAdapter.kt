package com.example.hallisanthe.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hallisanthe.ProductDetailActivity
import com.example.hallisanthe.R
import com.example.hallisanthe.model.Product

class ProductAdapter(
    private var productList: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val productImage: ImageView =
            itemView.findViewById(R.id.productImage)

        val productName: TextView =
            itemView.findViewById(R.id.productName)

        val productPrice: TextView =
            itemView.findViewById(R.id.productPrice)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {

        val product = productList[position]

        holder.productName.text = product.name

        holder.productPrice.text = "₹${product.price}"

        holder.productImage.setImageResource(product.image)

        holder.itemView.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                ProductDetailActivity::class.java
            )

            intent.putExtra("product", product)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}