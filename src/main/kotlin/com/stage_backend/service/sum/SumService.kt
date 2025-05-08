package com.stage_backend.service.sum

import com.stage_backend.domain.Summation
import com.stage_backend.domain.SumResult
import org.springframework.stereotype.Service

@Service
class SumService {

    fun calculate(
        summation: Summation
    ): SumResult {
        return summation.calculate()
    }
}