package com.example.data.base


data class BasePaginationInfo<T>(
    val info: BaseInfo,
    val results: List<T>
) {
    data class BaseInfo(
        val count: Int,
        val pages: Int,
        val next: String?,
        val prev: String?
    )
}