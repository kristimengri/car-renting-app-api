//package com.car.CarRenting.entity.location
//
//import jakarta.persistence.Entity
//import jakarta.persistence.GeneratedValue
//import jakarta.persistence.GenerationType
//import jakarta.persistence.Id
//import jakarta.persistence.JoinColumn
//import jakarta.persistence.ManyToOne
//
//@Entity
//class City {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long = 0
//
//    var name: String? = null
//
//    @ManyToOne
//    @JoinColumn(name = "state_id")
//    var state : State? = null
//}