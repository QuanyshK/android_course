package com.example.lab1.model

import com.example.lab1.R

object PizzaDataSource {
    val pizzaList: ArrayList<ParentPizza> = arrayListOf(
        Pizza(
            name = "Wow! Kebab",
            shortdescription = "Beef kebab, ranch sauce, mozarella cheese, sweet pepper, tomatoes, red onion, marinara sauce",
            price = 2900,
            imageRes = R.drawable.wowkebab
        ),
        Pizza(
            name = "Pepperoni with mushrooms",
            shortdescription = "Chicken pepperoni, mozarella cheese, mushrooms, alfredo sauce",
            price = 2000,
            imageRes = R.drawable.withmushrooms
        ),
        Pizza(
            name = "Ham&Pickles",
            shortdescription = "Ranch sauce, chicken ham, mozarella cheese, pickles, red onion",
            price = 2000,
            imageRes = R.drawable.hampickes
        ),
        NewPizza(
            name = "KikoRiki Combo",
            shortdescription = "Approved by cartoon characters: small pizza of any flavor and young gardener's kit Combo price depends on the selected pizzas and may change.",
            price = 2300,
            imageRes = R.drawable.combo1
        ),
        Pizza(
            name = "Cheesy",
            shortdescription = "Mozzarella cheese, cheddar cheese, parmesan cheese, Alfredo sauce",
            price = 1900,
            imageRes = R.drawable.cheesy
        ),
        Pizza(
            name = "Pepperoni Fresh",
            shortdescription = "Chicken pepperoni, extra mozzarella cheese, tomatoes, marinara sauce",
            price = 1900,
            imageRes = R.drawable.pepperonifresh
        ),
        Pizza(
            name = "Double Chicken",
            shortdescription = "Double chicken, mozzarella cheese, Alfredo sauce",
            price = 2900,
            imageRes = R.drawable.doublecincken
        ),
        NewPizza(
            name = "Bavarian",
            shortdescription = "Spicy chorizo sausages, pickled cucumbers, red onions, tomatoes, mustard sauce, mozzarella, signature tomato sauce",
            price = 1600,
            imageRes = R.drawable.combo3
        ),
        Pizza(
            name = "Chorizo fresh",
            shortdescription = "Spicy chorizo, sweet pepper, mozzarella cheese, marinara sauce",
            price = 1900,
            imageRes = R.drawable.chorizo
        ),
        Pizza(
            name = "Ham & Cheese",
            shortdescription = "Chicken ham, mozzarella cheese, Alfredo sauce",
            price = 1900,
            imageRes = R.drawable.hamcheese
        ),
        Pizza(
            name = "Carbonara",
            shortdescription = "Chicken ham, cheddar cheese, parmesan cheese, tomatoes, red onion, mozzarella cheese, Alfredo sauce, garlic, Italian seasoning",
            price = 2400,
            imageRes = R.drawable.carbonara
        ),
        Pizza(
            name = "Cheesy chicken",
            shortdescription = "Chicken, mozzarella cheese, cheddar cheese, parmesan cheese, cheese sauce, tomatoes, Alfredo sauce, garlic",
            price = 2900,
            imageRes = R.drawable.chessychicken
        ),

    )
}