package com.car.CarRenting.entity.account

import com.car.CarRenting.entity.Feedback
import com.car.CarRenting.entity.access.Booking
import com.car.CarRenting.entity.access.Token
import com.car.CarRenting.entity.car.Car
import com.car.CarRenting.entity.common.UserBaseEntity
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.security.Principal


@Entity
@Table(name = "_users")
class User : UserDetails, Principal, UserBaseEntity() {


    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JsonManagedReference
    var cars: MutableList<Car> = mutableListOf()

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JsonManagedReference
    var bookings: MutableList<Booking> = mutableListOf()

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    var tokens: MutableList<Token> = mutableListOf()

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JsonManagedReference
    var feedbacks: MutableList<Feedback> = mutableListOf()


    @Transient
    override fun getPassword(): String {
         return password ?: ""
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return TODO("Provide the return value")
    }

    override fun getUsername(): String {
        return email!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return !accountLocked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getName(): String {
        return email!!
    }

    fun fullname(): String {
        return firstname!! + " " + lastname!!
    }

}