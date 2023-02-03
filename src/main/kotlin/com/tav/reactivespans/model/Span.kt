package com.tav.reactivespans.model

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
)
