package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import com.example.lab1.adapter.PizzaAdapter
import com.example.lab1.databinding.ActivityMainBinding
import com.example.lab1.model.Pizza
import com.example.lab1.model.PizzaDataSource
import com.example.lab1.model.PizzaDataSource.pizzaList
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchView: SearchView
    private lateinit var adapter: PizzaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchView = findViewById(R.id.search)
        adapter= PizzaAdapter(
            onPizzaClick = {
                handlePizzaClick(it)
            }
        )
        adapter?.setData(PizzaDataSource.pizzaList)
        binding.recyclerView.adapter = adapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return false
            }
        })

    }

    private fun filterList(query: String?) {
        if(query!=null){
            val filteredList=ArrayList<Pizza>()
            for(i in pizzaList) {
                if (i.name.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }
            if(filteredList.isEmpty()){
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show()
            }
            else {
                adapter.setData(filteredList)
            }
        }
    }

    private fun handlePizzaClick(pizza: Pizza){
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("pizza", pizza)
        startActivity(intent)
    }
}