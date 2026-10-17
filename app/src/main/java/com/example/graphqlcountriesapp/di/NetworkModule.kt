package com.example.graphqlcountriesapp.di

import com.apollographql.apollo.ApolloClient
import com.example.graphqlcountriesapp.data.ApolloCountryClient
import com.example.graphqlcountriesapp.domain.usecase.GetCountriesUseCase
import com.example.graphqlcountriesapp.domain.usecase.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/")
            .build()
    }


    @Provides
    @Singleton
    fun provideApolloCountryClient(apolloClient: ApolloClient): ApolloCountryClient {
        return ApolloCountryClient(
            apolloClient = apolloClient
        )
    }

    @Provides
    @Singleton
    fun provideCountriesUseCase(apolloCountryClient: ApolloCountryClient): GetCountriesUseCase {
        return GetCountriesUseCase(countryClient = apolloCountryClient)
    }


    @Provides
    fun provideGetCountryUseCase(apolloCountryClient: ApolloCountryClient): GetCountryUseCase {
        return GetCountryUseCase(countryClient = apolloCountryClient)
    }


}