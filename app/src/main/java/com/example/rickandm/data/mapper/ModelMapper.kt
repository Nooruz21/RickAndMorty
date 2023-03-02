package com.example.rickandm.data.mapper

interface ModelMapper<T> {
    fun toDomain(): T
}