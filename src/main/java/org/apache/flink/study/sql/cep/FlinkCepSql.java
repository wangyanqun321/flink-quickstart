package org.apache.flink.study.sql.cep;

import org.apache.flink.study.util.SqlEnv;

public class FlinkCepSql {

    public static void main(String[] args) {
        SqlEnv sqlEnv = SqlEnv.getInstance();
        sqlEnv.createTable("01-cep-helloword-kafka-source.sql");
        sqlEnv.sendData("01-cep-helloworld-data.txt");
        sqlEnv.query("01-cep-helloword-query.sql");
    }

}
