package com.tav.reactivespans

import com.tav.reactivespans.model.Span
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@RestController
@RequestMapping("span")
class SpanController (val spanRepository: SpanRepository) {
    @PostMapping
    fun create(@RequestBody span: Span) = spanRepository.save(span)

    @GetMapping
    fun getAll(): Flux<Span> = spanRepository.findAll().zipWith(
        Flux.interval(Duration.ofMillis(1)
    )).map {
        println(Thread.currentThread().id)
        it.t1
    }

    @GetMapping("count")
    fun count(): Mono<Long> = spanRepository.count()
}