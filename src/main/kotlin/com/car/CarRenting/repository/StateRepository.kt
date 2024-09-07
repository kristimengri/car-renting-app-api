package com.car.CarRenting.repository

import com.car.CarRenting.entity.location.State
import org.springframework.data.jpa.repository.JpaRepository

interface StateRepository : JpaRepository<State, Long> {

    fun findByCountryId(countryId: Long): List<State>
}