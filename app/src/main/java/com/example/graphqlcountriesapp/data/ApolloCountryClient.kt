package com.example.graphqlcountriesapp.data

import com.apollographql.apollo.ApolloClient
import com.example.CountriesQuery
import com.example.CountryQuery
import com.example.graphqlcountriesapp.data.mapper.toDetailedCountry
import com.example.graphqlcountriesapp.data.mapper.toSimpleCountry
import com.example.graphqlcountriesapp.domain.CountryClient
import com.example.graphqlcountriesapp.domain.model.DetailedCountry
import com.example.graphqlcountriesapp.domain.model.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient.query(CountriesQuery()).execute().data?.countries?.map {
            it.toSimpleCountry()
        } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient.query(CountryQuery(code = code))
            .execute().data?.country?.toDetailedCountry()
    }
}