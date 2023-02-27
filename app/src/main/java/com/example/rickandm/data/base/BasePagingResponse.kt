package com.example.rickandm.data.base


data class BasePagingResponse<T>(
    val info: BaseInfo,
    val results: List<T>
)