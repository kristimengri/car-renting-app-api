package com.car.CarRenting.config

import com.car.CarRenting.entity.location.City
import com.car.CarRenting.entity.location.Country
import com.car.CarRenting.entity.location.State
import com.car.CarRenting.repository.CityRepository
import com.car.CarRenting.repository.CountryRepository
import com.car.CarRenting.repository.StateRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.io.BufferedReader
import java.io.InputStreamReader

@Configuration
class DataLoader(
    private val countryRepository: CountryRepository,
    private val stateRepository: StateRepository,
    private val cityRepository: CityRepository
) {

    @Bean
    fun loadData(): CommandLineRunner = CommandLineRunner {
        loadCountries()
        loadStates()
        loadCities()
    }


    private fun loadCountries() {
        val reader = BufferedReader(InputStreamReader(ClassPathResource("countries.csv").inputStream))
        reader.use {
            it.readLine()
            var line: String? = it.readLine()
            while (line != null) {
                val values = line.split(",")
                val country = Country().apply {
                    id = values[0].toLong()
                    name = values[1]
                }
                countryRepository.save(country)
                line = it.readLine()
            }
        }
    }


    private fun loadStates() {
        val reader = BufferedReader(InputStreamReader(ClassPathResource("states.csv").inputStream))
        reader.use {
            it.readLine()
            var line: String? = it.readLine()
            while (line != null) {
                val values = line.split(",")
                val state = State().apply {
                    id = values[0].toLong()
                    name = values[1]
                    country = countryRepository.findById(values[2].toLong()).orElse(null)
                }
                stateRepository.save(state)
                line = it.readLine()
            }
        }
    }

    private fun loadCities() {
        val reader = BufferedReader(InputStreamReader(ClassPathResource("cities.csv").inputStream))
        reader.use {
            it.readLine() // Skip header
            var line: String? = it.readLine()
            while (line != null) {
                val values = line.split(",")
                val city = City().apply {
                    id = values[0].toLong()
                    name = values[1]
                    state = stateRepository.findById(values[2].toLong()).orElse(null)
                }
                cityRepository.save(city)
                line = it.readLine()
            }
        }
    }

}