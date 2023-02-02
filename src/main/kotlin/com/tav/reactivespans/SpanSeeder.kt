package com.tav.reactivespans

import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.tav.reactivespans.model.Span
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.*

@Component
class SpanSeeder(private val spanRepository: SpanRepository) : ApplicationRunner {

    private val random = Random()

    override fun run(args: ApplicationArguments?) {
        val amt = 0
        val spanIds = (1..amt).map { UUID.randomUUID().toString() }
        val traceIds = (1..amt).map { UUID.randomUUID().toString() }
        val parentSpanIds = (1..amt).map { UUID.randomUUID().toString() }
        val names = (1..amt).map { "span-$it" }
        val statusMessages = (1..amt).map { "status-message-$it" }
        val spanAttributes = (1..amt).map { JsonNodeFactory.instance.objectNode().put("attribute-$it", "value-$it") }

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
                durationMilis = random.nextLong(50000),
                droppedSpanAttributesCount = random.nextInt(100),
                droppedResourceAttributesCount = random.nextInt(100),
                droppedEventsCount = random.nextInt(100),
                droppedLinksCount = random.nextInt(100),
                statusMessage = if (i % 2 == 0) statusMessages[i] else null,
                statusCode = if (i % 2 == 0) random.nextInt(100) else null,
                ingestionTimeUnixNano = System.currentTimeMillis(),
            )).subscribe{s -> println(s)}
        }
    }
}
