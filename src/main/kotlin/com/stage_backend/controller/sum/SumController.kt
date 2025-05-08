package com.stage_backend.controller.sum

import com.stage_backend.common.ApiResponse
import com.stage_backend.controller.sum.mapper.toResponse
import com.stage_backend.controller.sum.model.SumRequest
import com.stage_backend.controller.sum.model.SumResponse
import com.stage_backend.service.sum.SumService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sum")
class SumController(
    private val sumService: SumService
) {
    @PostMapping
    fun sum(
        @Valid @RequestBody request: SumRequest
    ): ApiResponse<SumResponse> {
        val result = sumService.calculate(request.toDomain())
        return result.toResponse()
    }
}