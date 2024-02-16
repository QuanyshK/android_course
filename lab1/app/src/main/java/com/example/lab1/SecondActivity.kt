package com.example.lab1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import com.example.lab1.databinding.ActivitySecondBinding
import com.example.lab1.model.Pizza
import androidx.navigation.Navigation
class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pizza:Pizza= intent.extras?.getSerializable("pizza") as Pizza
        with(binding) {
            binding.pizzaphoto.setImageResource(pizza.imageRes)
            binding.name.text = pizza.name
            binding.description.text = pizza.shortdescription
            binding.btn.text="Add to cart " + pizza.price.toString() + " KZT"
        }
    }
}