create table inputTable
(
    `timestamp` TIMESTAMP(0),
    `card_id`   VARCHAR,
    `location`  VARCHAR,
    `action`    VARCHAR,
    `wf` AS `timestamp`,
    WATERMARK FOR wf AS wf - INTERVAL '1' SECOND
) with ('connector' = 'kafka', 'topic' = 'test',
      'properties.bootstrap.servers' = 'node1:9092',
      'properties.group.id' = 'test',
      'scan.startup.mode' = 'latest-offset', 'format' = 'csv')