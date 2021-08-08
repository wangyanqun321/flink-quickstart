--- 找出一个单一股票价格不断下降的时期
SELECT *
FROM Ticker
         MATCH_RECOGNIZE (
                          PARTITION BY symbol
        ORDER BY rowtime
        MEASURES
            START_ROW.rowtime AS start_tstamp,
                          LAST(PRICE_DOWN.rowtime) AS bottom_tstamp,
                          LAST(PRICE_UP.rowtime) AS end_tstamp
        ONE ROW PER MATCH
        AFTER MATCH SKIP TO LAST PRICE_UP
        PATTERN (START_ROW PRICE_DOWN+ PRICE_UP)
        DEFINE
            PRICE_DOWN AS
                (LAST(PRICE_DOWN.price, 1) IS NULL AND PRICE_DOWN.price < START_ROW.price) OR
                    PRICE_DOWN.price < LAST(PRICE_DOWN.price, 1),
                          PRICE_UP AS
                PRICE_UP.price > LAST(PRICE_DOWN.price, 1)
        )