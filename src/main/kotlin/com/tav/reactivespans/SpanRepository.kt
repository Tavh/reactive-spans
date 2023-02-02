package com.tav.reactivespans

import com.tav.reactivespans.model.Span
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface SpanRepository : ReactiveCrudRepository<Span, String>

