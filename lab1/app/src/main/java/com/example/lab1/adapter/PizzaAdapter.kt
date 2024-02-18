package com.example.lab1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.databinding.ItemNewpizzaBinding
import com.example.lab1.databinding.ItemPizzaBinding
import com.example.lab1.model.ParentPizza
import com.example.lab1.model.Pizza

class PizzaAdapter(
    private val onPizzaClick: (ParentPizza) -> Unit,
    private val onNewPizzaClick: (ParentPizza) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val pizzaList: ArrayList<ParentPizza> = ArrayList()

    fun setData(pizzas: List<ParentPizza>) {
        pizzaList.clear()
        pizzaList.addAll(pizzas)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_PIZZA) {
            PizzaViewHolder(
                ItemPizzaBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        } else {
            NewPizzaViewHolder(
                ItemNewpizzaBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pizza = pizzaList[position]
        when (holder) {
            is PizzaViewHolder -> holder.bind(pizza)
            is NewPizzaViewHolder -> holder.bind(pizza)
        }
    }

    override fun getItemCount() = pizzaList.size

    override fun getItemViewType(position: Int): Int {
        return if (pizzaList[position] is Pizza) {
            VIEW_TYPE_PIZZA
        } else {
            VIEW_TYPE_NEW_PIZZA
        }
    }

    inner class PizzaViewHolder(private val binding: ItemPizzaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: ParentPizza) {
            with(binding) {
                pizzaphoto.setImageResource(pizza.imageRes)
                name.text = pizza.name
                smalldescription.text = pizza.shortdescription
                price.text = pizza.price.toString() + " KZT"
                root.setOnClickListener { onPizzaClick(pizza) }
            }
        }
    }

    inner class NewPizzaViewHolder(private val binding: ItemNewpizzaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: ParentPizza) {
            with(binding) {
                npizza.setImageResource(pizza.imageRes)
                nname.text = pizza.name
                nsmalldescription.text = pizza.shortdescription
                nprice.text = pizza.price.toString() + " KZT"
                root.setOnClickListener { onNewPizzaClick(pizza) }
            }
        }
    }

    companion object {
        private const val VIEW_TYPE_PIZZA = 0
        private const val VIEW_TYPE_NEW_PIZZA = 1
    }
}