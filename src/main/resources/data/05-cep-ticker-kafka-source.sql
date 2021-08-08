create table Ticker
(
    `symbol`  VARCHAR,
    `tax`     BIGINT,
    `price`   DOUBLE,
    `rowtime` TIMESTAMP(0),
    WATERMARK FOR rowtime AS rowtime - INTERVAL '1' SECOND
)
    with ('connector' = 'kafka', 'topic' = 'test',
        'properties.bootstrap.servers' = 'node1:9092', 'properties.group.id' = 'test',
        'scan.startup.mode' = 'latest-offset', 'format' = 'csv')