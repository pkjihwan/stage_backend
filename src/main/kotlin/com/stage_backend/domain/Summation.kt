package com.stage_backend.domain

data class Summation(
    val a: Int,
    val b: Int
) {
    fun calculate(): SumResult = SumResult(a + b)
}

data class SumResult(val total: Int)
