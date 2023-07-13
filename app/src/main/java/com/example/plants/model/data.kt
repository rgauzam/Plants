package com.example.plants.model

import com.example.plants.R

val PreviewPlant = Plant(
    nameRes = R.string.plant1,
    descriptionRes = R.string.description1,
    imageRes = R.drawable.ficus_tineke
)

class data {
    object PlantsRepository {
        val plants = listOf(
            Plant(
                nameRes = R.string.plant1,
                descriptionRes = R.string.description1,
                imageRes = R.drawable.ficus_tineke
            ),
            Plant(
                nameRes = R.string.plant2,
                descriptionRes = R.string.description2,
                imageRes = R.drawable.grubosz
            ),
            Plant(
                nameRes = R.string.plant3,
                descriptionRes = R.string.description3,
                imageRes = R.drawable.moonshine
            ),
            Plant(
                nameRes = R.string.plant4,
                descriptionRes = R.string.description4,
                imageRes = R.drawable.epi
            ),
            Plant(
                nameRes = R.string.plant5,
                descriptionRes = R.string.description5,
                imageRes = R.drawable.philodendron_erubescens
            ),
            Plant(
                nameRes = R.string.plant6,
                descriptionRes = R.string.description6,
                imageRes = R.drawable.brasil
            ),
            Plant(
                nameRes = R.string.plant7,
                descriptionRes = R.string.description7,
                imageRes = R.drawable.satin
            ),
            Plant(
                nameRes = R.string.plant8,
                descriptionRes = R.string.description8,
                imageRes = R.drawable.aeschynanthus_marmoratus
            ),


            )
    }
}