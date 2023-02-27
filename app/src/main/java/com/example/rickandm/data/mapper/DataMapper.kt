package com.example.rickandm.data.mapper

interface DataMapper<T> {
    fun toDomain():T
}