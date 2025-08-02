package com.car.CarRenting.entity.access

import com.car.CarRenting.entity.account.User
import com.car.CarRenting.entity.common.BaseEntity
import com.car.CarRenting.enums.BookingStatusEnum
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "bookings")
class Booking : BaseEntity(){

    @Column(name = "startDate")
    var startDate: LocalDateTime? = null

    @Column(name = "endDate")
    var endDate: LocalDateTime? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var bookingStatus: BookingStatusEnum? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    var user: User? = null

}