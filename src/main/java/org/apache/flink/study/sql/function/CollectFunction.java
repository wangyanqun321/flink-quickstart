package org.apache.flink.study.sql.function;

import org.apache.flink.study.util.SqlEnv;

public class CollectFunction {

    public static void main(String[] args) {
        SqlEnv sqlEnv = SqlEnv.getInstance();
        sqlEnv.createTable("06-collect-function-kafka-source.sql");
        sqlEnv.sendData("06-collect-function-data.txt");
        sqlEnv.queryToRetractStream("06-collect-function-query.sql");
    }

}
