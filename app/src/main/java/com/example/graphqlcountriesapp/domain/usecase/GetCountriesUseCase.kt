package com.example.graphqlcountriesapp.domain.usecase

import com.example.graphqlcountriesapp.domain.CountryClient
import com.example.graphqlcountriesapp.domain.model.SimpleCountry

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(): List<SimpleCountry> {
        return countryClient.getCountries().sortedBy {
            it.name
        }
    }
}