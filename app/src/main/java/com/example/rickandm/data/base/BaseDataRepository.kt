package com.example.rickandm.data.base

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandm.data.mapper.ModelMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

open class BaseDataRepository() {
    companion object {
        internal fun <ValueDto : ModelMapper<Value>, Value : Any> doPagingRequest(
            pagingSource: BasePagingSource<ValueDto, Value>,
            pageSize: Int = 10,
            prefetchDistance: Int = pageSize,
            enablePlaceholders: Boolean = true,
            initialLoadSize: Int = pageSize * 3,
            maxSize: Int = Int.MAX_VALUE,
            jumpThreshold: Int = Int.MIN_VALUE
        ) = Pager(
            config = PagingConfig(
                pageSize,
                prefetchDistance,
                enablePlaceholders,
                initialLoadSize,
                maxSize,
                jumpThreshold
            ),
            pagingSourceFactory = {
                pagingSource
            }
        ).flow
    }
}

