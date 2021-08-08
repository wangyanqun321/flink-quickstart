create table MyTable
(
    `id`   INT,
    `userid` INT,
    `name` VARCHAR,
    `proctime` TIMESTAMP(0),
    WATERMARK FOR proctime AS proctime - INTERVAL '1' SECOND
)
    with ('connector' = 'kafka', 'topic' = 'test',
        'properties.bootstrap.servers' = 'node1:9092', 'properties.group.id' = 'test',
        'scan.startup.mode' = 'latest-offset', 'format' = 'csv')