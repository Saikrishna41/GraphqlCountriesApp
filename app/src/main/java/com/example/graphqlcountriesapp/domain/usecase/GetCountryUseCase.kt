package com.example.graphqlcountriesapp.domain.usecase

import com.example.graphqlcountriesapp.domain.CountryClient
import com.example.graphqlcountriesapp.domain.model.DetailedCountry

class GetCountryUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}