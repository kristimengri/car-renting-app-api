package com.car.CarRenting.repository

import com.car.CarRenting.entity.location.City
import org.springframework.data.jpa.repository.JpaRepository

interface CityRepository: JpaRepository<City, Long> {

    fun findByStateId(stateId: Long): List<City>
}