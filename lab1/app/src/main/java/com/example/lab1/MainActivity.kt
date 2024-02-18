package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import com.example.lab1.adapter.PizzaAdapter
import com.example.lab1.databinding.ActivityMainBinding
import com.example.lab1.model.ParentPizza
import com.example.lab1.model.Pizza
import com.example.lab1.model.PizzaDataSource
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchView: SearchView
    private lateinit var adapter: PizzaAdapter
    private var pizzaList: List<ParentPizza> = PizzaDataSource.pizzaList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchView = binding.search
        adapter = PizzaAdapter(
            onPizzaClick = { handlePizzaClick(it) },
            onNewPizzaClick = { handleNewPizzaClick(it) }
        )
        adapter.setData(pizzaList)
        binding.recyclerView.adapter = adapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true


            }
        })
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = pizzaList.filter { it.name.lowercase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT)) }
            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setData(filteredList)
            }
        }
        else {
            adapter.setData(pizzaList)
        }
    }
    private fun handlePizzaClick(pizza: ParentPizza) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("pizza", pizza)
        startActivity(intent)
    }

    private fun handleNewPizzaClick(pizza: ParentPizza) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("pizza", pizza)
        startActivity(intent)
    }
}