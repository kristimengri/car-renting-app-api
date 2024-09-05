package com.car.CarRenting.dto.request

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

class FeedbackRequest {

    @Positive(message = "200")
    @Min(value = 0 ,message = "201")
    @Max(value = 5, message = "202")
    val note: Double? = null

    @NotNull(message = "203")
    @NotEmpty(message = "203")
    @NotBlank(message = "203")
    val comment: String? = null

    @NotNull(message = "204")
    val carId: Long? = null
}