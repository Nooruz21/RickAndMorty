package com.example.domain.utils

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

internal typealias RemotePagingWrapper<T> = Flow<PagingData<T>>