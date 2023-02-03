package com.tav.reactivespans

import com.tav.reactivespans.model.Span
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.*

@Component
class SpanSeeder(private val spanRepository: ReactiveSpanRepository) : ApplicationRunner {

    private val random = Random()

    override fun run(args: ApplicationArguments?) {
        val amt = 5000
        val spanIds = (1..amt).map { UUID.randomUUID().toString() }
        val traceIds = (1..amt).map { UUID.randomUUID().toString() }
        val parentSpanIds = (1..amt).map { UUID.randomUUID().toString() }
        val names = (1..amt).map { "span-$it" }

        (0 until amt).forEach { i ->
            spanRepository.save(Span(
                spanId = spanIds[i],
                traceId = traceIds[i],
                traceState = null,
                parentSpanId = if (i % 2 == 0) parentSpanIds[i] else null,
                name = names[i],
                kind = random.nextInt(3),
                startTimeUnixNano = System.currentTimeMillis(),
                endTimeUnixNano = System.currentTimeMillis() + random.nextInt(amt),
            )).subscribe{s -> println(s)}
        }
    }
}
