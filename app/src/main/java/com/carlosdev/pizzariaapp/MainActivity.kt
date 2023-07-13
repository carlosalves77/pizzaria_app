package com.carlosdev.pizzariaapp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.carlosdev.pizzariaapp.adapter.ProductAdapter
import com.carlosdev.pizzariaapp.databinding.ActivityMainBinding
import com.carlosdev.pizzariaapp.listitems.Products
import com.carlosdev.pizzariaapp.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter
    private val products = Products()
    private val productList: MutableList<Product> = mutableListOf()
    var clicked = false

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       window.statusBarColor = Color.parseColor("#E0E0E0")

        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed {
                index, value ->
                for (p in value) {
                    productList.add(p)
                }
            }
        }

        val recyclerViewProducts = binding.recyclerViewProducts
        recyclerViewProducts.layoutManager = GridLayoutManager(this, 2)
        recyclerViewProducts.setHasFixedSize(true)
        productAdapter = ProductAdapter(this, productList)
        recyclerViewProducts.adapter = productAdapter


        binding.btAll.setOnClickListener {
            clicked = true
            if (clicked) {
                binding.btAll.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btAll.setTextColor(Color.WHITE)
                binding.btChicken.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btChicken.setTextColor(R.color.dark_gray)
                binding.btKebab.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btKebab.setTextColor(R.color.dark_gray)
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.textListTitle.text = "All"
            }
        }

        binding.btChicken.setOnClickListener {
            clicked = true
            if (clicked) {
                binding.btChicken.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btChicken.setTextColor(Color.WHITE)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)
                binding.btKebab.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btKebab.setTextColor(R.color.dark_gray)
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.textListTitle.text = "Chicken"
            }
        }

        binding.btPizza.setOnClickListener {
            clicked = true
            if (clicked) {
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btPizza.setTextColor(Color.WHITE)
                binding.btChicken.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btChicken.setTextColor(R.color.dark_gray)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)
                binding.btKebab.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btKebab.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.textListTitle.text = "Pizza"

            }
        }

        binding.btKebab.setOnClickListener {
            clicked = true
            if (clicked) {
                binding.btKebab.setBackgroundResource(R.drawable.bg_button_enable)
                binding.btKebab.setTextColor(Color.WHITE)
                binding.btPizza.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btPizza.setTextColor(R.color.dark_gray)
                binding.btChicken.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btChicken.setTextColor(R.color.dark_gray)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.dark_gray)
                binding.recyclerViewProducts.visibility = View.INVISIBLE
                binding.textListTitle.text = "Kebab"

            }
        }

    }
}