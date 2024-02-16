package com.example.lab1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.databinding.ItemPizzaBinding
import com.example.lab1.model.Pizza

class PizzaAdapter(
    private val onPizzaClick:(Pizza) -> Unit
) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>(){
    private  val pizzaList: ArrayList<Pizza> = ArrayList()
    fun setData(pizzas: ArrayList<Pizza>) {
        pizzaList.clear()
        pizzaList.addAll(pizzas)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding:ItemPizzaBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: Pizza) {
            with(binding) {
                binding.pizzaphoto.setImageResource(pizza.imageRes)
                binding.name.text = pizza.name
                binding.smalldescription.text = pizza.shortdescription
                binding.price.text= pizza.price.toString()+" KZT"
                root.setOnClickListener{
                    onPizzaClick(pizza)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPizzaBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = pizzaList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pizzaList[position])
    }
}