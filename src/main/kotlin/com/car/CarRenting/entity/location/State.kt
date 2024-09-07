package com.car.CarRenting.entity.location

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var name : String? = null

    @ManyToOne
    @JoinColumn(name = "country_id")
    var country : Country? = null

    @OneToMany(mappedBy = "state")
    var cities : List<City> = ArrayList()
}