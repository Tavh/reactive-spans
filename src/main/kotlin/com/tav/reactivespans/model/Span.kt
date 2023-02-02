package com.tav.reactivespans.model

import com.fasterxml.jackson.databind.JsonNode
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("spans")
data class Span(
    @Column("span_id")
    val spanId: String,

    @Column("trace_id")
    val traceId: String,

    @Column("trace_state")
    val traceState: String?,

    @Column("parent_span_id")
    val parentSpanId: String?,

    @Column("name")
    val name: String,

    @Column("kind")
    val kind: Int,

    @Column("start_time_unix_nano")
    val startTimeUnixNano: Long,

    @Column("end_time_unix_nano")
    val endTimeUnixNano: Long,

    @Column("duration_milis")
    val durationMilis: Long,

    @Column("dropped_span_attributes_count")
    val droppedSpanAttributesCount: Int,

    @Column("dropped_resource_attributes_count")
    val droppedResourceAttributesCount: Int,

    @Column("dropped_events_count")
    val droppedEventsCount: Int,

    @Column("dropped_links_count")
    val droppedLinksCount: Int,

    @Column("status_message")
    val statusMessage: String?,

    @Column("status_code")
    val statusCode: Int?,

    @Column("ingestion_time_unix_nano")
    val ingestionTimeUnixNano: Long,
)
