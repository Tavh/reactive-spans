package com.tav.reactivespans

import com.tav.reactivespans.model.Span
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration


@RestController
@RequestMapping("span")
class ReactiveSpanController (val reactiveSpanRepository: ReactiveSpanRepository) {
    @GetMapping
    fun all(): Flux<Span> =
            reactiveSpanRepository
            .findAll()
            .zipWith(Flux.interval(Duration.ofMillis(2000)))
            .map { it.t1 }

    @GetMapping("count")
    fun count(): Mono<Long> = reactiveSpanRepository.count()
}