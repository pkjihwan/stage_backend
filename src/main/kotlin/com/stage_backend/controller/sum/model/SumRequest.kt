package com.stage_backend.controller.sum.model

import com.stage_backend.domain.Summation
import jakarta.validation.constraints.Min

data class SumRequest(
    @field:Min(0) val a: Int,
    @field:Min(0) val b: Int
) {
    fun toDomain(): Summation = Summation(a, b)
}