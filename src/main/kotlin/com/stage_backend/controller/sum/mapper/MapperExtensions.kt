package com.stage_backend.controller.sum.mapper

import com.stage_backend.common.ApiResponse
import com.stage_backend.common.toResponse
import com.stage_backend.controller.sum.model.SumResponse
import com.stage_backend.domain.SumResult

fun SumResult.toResponse(): ApiResponse<SumResponse> =
    SumResponse(total).toResponse()
