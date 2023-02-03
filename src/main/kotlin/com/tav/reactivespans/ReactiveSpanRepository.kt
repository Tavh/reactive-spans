package com.tav.reactivespans

import com.tav.reactivespans.model.Span
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ReactiveSpanRepository : ReactiveCrudRepository<Span, String>

