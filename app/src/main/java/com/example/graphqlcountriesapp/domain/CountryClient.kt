package com.example.graphqlcountriesapp.domain

import com.example.CountryQuery
import com.example.graphqlcountriesapp.domain.model.DetailedCountry
import com.example.graphqlcountriesapp.domain.model.SimpleCountry

interface CountryClient {
    suspend fun getCountries() : List<SimpleCountry>

    suspend fun getCountry(code : String) : DetailedCountry?
}