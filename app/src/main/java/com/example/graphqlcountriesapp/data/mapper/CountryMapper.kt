package com.example.graphqlcountriesapp.data.mapper

import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.graphqlcountriesapp.domain.model.DetailedCountry
import com.example.graphqlcountriesapp.domain.model.SimpleCountry

fun CountryQuery.Country.toDetailedCountry() : DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.map { it.name },
        continent = continent.name
    )
}


fun CountriesQuery.Country.toSimpleCountry() : SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "no capital"
    )
}