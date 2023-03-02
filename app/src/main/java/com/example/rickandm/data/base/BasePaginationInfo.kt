package com.example.rickandm.data.base


data class BasePaginationInfo<T>(
    val info: BaseInfo,
    val results: List<T>
)