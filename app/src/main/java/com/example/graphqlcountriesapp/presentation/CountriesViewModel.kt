package com.example.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlcountriesapp.domain.model.DetailedCountry
import com.example.graphqlcountriesapp.domain.model.SimpleCountry
import com.example.graphqlcountriesapp.domain.usecase.GetCountriesUseCase
import com.example.graphqlcountriesapp.domain.usecase.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@HiltViewModel
class CountriesViewModel @Inject constructor (
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
) : ViewModel() {

    private val _countryState = MutableStateFlow(CountriesState())
    val countryState = _countryState.asStateFlow()

    init {
        viewModelScope.launch {
            _countryState.update {
                it.copy(
                    isLoading = true
                )
            }
            _countryState.update {
                it.copy(
                    countries = getCountriesUseCase.execute(),
                    isLoading = false
                )
            }
        }
    }


    fun selectCountry(code : String) {
        viewModelScope.launch {
            _countryState.update {
                it.copy(
                    selectedCountry = getCountryUseCase.execute(code)
                )
            }
        }
    }

    fun dimiss() {
        _countryState.update {
            it.copy(
                selectedCountry = null
            )
        }
    }


    data class CountriesState(
        val countries : List<SimpleCountry> = emptyList(),
        val isLoading : Boolean = false,
        val selectedCountry : DetailedCountry? = null
    )
}