create table Ticker
(
    `symbol`  VARCHAR,
    `rowtime` TIMESTAMP(0),
    `price`   DOUBLE,
    `tax`     BIGINT,
    WATERMARK FOR rowtime AS rowtime - INTERVAL '1' SECOND
)
    with ('connector' = 'kafka', 'topic' = 'test',
        'properties.bootstrap.servers' = 'node1:9092', 'properties.group.id' = 'test',
        'scan.startup.mode' = 'latest-offset', 'format' = 'csv')