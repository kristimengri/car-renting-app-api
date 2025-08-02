package com.car.CarRenting.entity.car

import com.car.CarRenting.entity.common.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "car_transaction_histories")
class CarTransactionHistory : BaseEntity() {

    //carRelationship


    var returned: Boolean = false
    var returnedApproved: Boolean = false

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    @JsonBackReference
    var car: Car? = null

}