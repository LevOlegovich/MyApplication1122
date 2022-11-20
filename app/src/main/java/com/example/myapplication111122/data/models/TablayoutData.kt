package com.example.myapplication111122.data.models


import com.example.myapplication111122.R

class TablayoutData {

companion object{
    val categoriesList: List<CategoriesModel> = listOf(
        CategoriesModel(
            0,
            "Phones",
            R.drawable.ic_phones
        ),
        CategoriesModel(
            1,
            "Computer",
            R.drawable.ic_computer
        ),
        CategoriesModel(
            2,
            "Health",
            R.drawable.ic_health
        ),
        CategoriesModel(
            3,
            "Books",
            R.drawable.ic_books
        ),
        CategoriesModel(
            4,
            "Pets",
            R.drawable.ic_pets
        )
    )
}

}