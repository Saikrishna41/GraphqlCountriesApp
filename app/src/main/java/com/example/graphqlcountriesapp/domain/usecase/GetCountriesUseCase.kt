package com.example.graphqlcountriesapp.domain.usecase

import com.example.graphqlcountriesapp.domain.CountryClient
import com.example.graphqlcountriesapp.domain.model.SimpleCountry
import jakarta.inject.Inject

class GetCountriesUseCase @Inject constructor (
    private val countryClient: CountryClient
) {
    suspend fun execute(): List<SimpleCountry> {
        return countryClient.getCountries().sortedBy {
            it.name
        }
    }
}