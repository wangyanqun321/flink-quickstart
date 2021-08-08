package org.apache.flink.study.sql.cep;

import org.apache.flink.study.util.SqlEnv;

public class FlinkCepSql3 {

    public static void main(String[] args) {
        SqlEnv sqlEnv = SqlEnv.getInstance();
        sqlEnv.createTable("03-cep-ticker-kafka-source.sql");
        sqlEnv.query("03-cep-ticker-query.sql");
    }

}