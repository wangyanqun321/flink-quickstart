--- 找出平均价格小于15的区间
SELECT *
FROM Ticker
         MATCH_RECOGNIZE (
                          PARTITION BY symbol
        ORDER BY rowtime
        MEASURES
            FIRST(A.rowtime) AS start_tstamp,
                          LAST(A.rowtime) AS end_tstamp,
                          AVG(A.price) AS avgPrice
        ONE ROW PER MATCH
        AFTER MATCH SKIP PAST LAST ROW
        PATTERN (A+ B)
        DEFINE
            A AS AVG(A.price) < 15
        )