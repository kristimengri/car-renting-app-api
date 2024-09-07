package com.car.CarRenting.repository

import com.car.CarRenting.entity.location.Country
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository<Country, Long> {
}