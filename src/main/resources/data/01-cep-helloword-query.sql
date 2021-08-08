--- 找出连续三个事件的name为a,b,c的匹配
SELECT T.aid, T.bid, T.cid
FROM MyTable
         MATCH_RECOGNIZE (
                          PARTITION BY userid
      ORDER BY proctime
      MEASURES
        A.id AS aid,
        B.id AS bid,
        C.id AS cid
      PATTERN (A B C)
      DEFINE
        A AS name = 'a',
                          B AS name = 'b',
                          C AS name = 'c'
        ) AS T