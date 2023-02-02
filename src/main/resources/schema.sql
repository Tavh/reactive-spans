CREATE TABLE spans (
  span_id varchar(255) NOT NULL,
  trace_id varchar(255) NOT NULL,
  trace_state varchar(255),
  parent_span_id varchar(255),
  name varchar(255) NOT NULL,
  kind int NOT NULL,
  start_time_unix_nano bigint NOT NULL,
  end_time_unix_nano bigint NOT NULL,
  duration_milis bigint NOT NULL,
  dropped_span_attributes_count int NOT NULL,
  dropped_resource_attributes_count int NOT NULL,
  dropped_events_count int NOT NULL,
  dropped_links_count int NOT NULL,
  status_message varchar(255),
  status_code int,
  ingestion_time_unix_nano bigint NOT NULL
);
