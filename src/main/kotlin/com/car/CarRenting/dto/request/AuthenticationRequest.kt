package com.car.CarRenting.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

class AuthenticationRequest {

    @Email(message = "Email is not correct")
    @NotEmpty(message = "Email Required")
    @NotBlank(message = "Email Required")
    var email: String? = null

    @NotEmpty(message = "Password Required")
    @NotBlank(message = "Password Required")
    @Size(min = 4, message = "Password must have at least 4 characters")
    var password: String? = null

}