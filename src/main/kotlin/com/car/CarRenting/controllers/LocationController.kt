package com.car.CarRenting.controllers

//import com.car.CarRenting.dto.response.CitiesResponse
import com.car.CarRenting.dto.response.CountriesResponse
//import com.car.CarRenting.dto.response.StatesResponse
//import com.car.CarRenting.entity.location.City
//import com.car.CarRenting.entity.location.Country
//import com.car.CarRenting.entity.location.State
//import com.car.CarRenting.repository.CityRepository
import com.car.CarRenting.repository.CountryRepository
//import com.car.CarRenting.repository.StateRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/locations")
class LocationController(
    private val countryRepository: CountryRepository,
//    private val stateRepository: StateRepository,
//    private val cityRepository: CityRepository,
){

    @GetMapping("/countries")
    fun getCountries(): List<CountriesResponse> {

        val countries = countryRepository.findAll()

        return countries.map { country ->
            CountriesResponse(
                id = country.id,
                name = country.name
            )
        }
    }

//    @GetMapping("/states")
//    fun getStates(@RequestParam countryId: Long): List<StatesResponse> {
//        val states = stateRepository.findByCountryId(countryId)
//
//        return states.map {
//            state -> StatesResponse(
//                id = state.id,
//                name = state.name,
//                countryId = countryId
//            )
//        }
//    }

//    @GetMapping("/cities")
//    fun getCities(@RequestParam stateId: Long): List<CitiesResponse> {
//        val cities = cityRepository.findByStateId(stateId)
//
//        return cities.map {
//            city -> CitiesResponse(
//                id = city.id,
//                name = city.name,
//                stateId = stateId
//            )
//        }
//    }

}