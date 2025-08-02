package com.car.CarRenting.dto.request


import com.car.CarRenting.enums.GenderEnum
import com.car.CarRenting.enums.RoleEnum
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

class RegistrationRequest {

    var userName: String? = null
    var gender: GenderEnum? = null
    var address: String? = null
    var city: String? = null
    var country: String? = null
    var phoneNumber: String? = null

    @NotEmpty(message = "Firstname Required")
    @NotBlank(message = "Firstname Required")
//  @NotEmptyString(message = "Firstname Required")
    var firstname: String? = null

    @NotEmpty(message = "Lastname Required")
    @NotBlank(message = "Lastname Required")
//  @NotEmptyString(message = "Lastname Required")
    var lastname: String?? = null

    @Email(message = "Email is not correct")
//  @EmailVerification(message = "Email is not correct")
    @NotEmpty(message = "Email Required")
    @NotBlank(message = "Email Required")
//  @NotEmptyString(message = "Empty Email Field")
    var email: String? = null

    @NotEmpty(message = "Password Required")
    @NotBlank(message = "Password Required")
    @Size(min = 4, message = "Password must have at least 4 characters")
//  @NotEmptyString(message = "Password must have at least 4 characters")
        var password: String? = null

    //    @NotEmpty(message = "")
//    @NotBlank(message = "")
    val role: RoleEnum? = null


}