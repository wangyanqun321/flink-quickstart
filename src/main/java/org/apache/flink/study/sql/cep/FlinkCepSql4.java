package org.apache.flink.study.sql.cep;

import org.apache.flink.study.util.SqlEnv;

public class FlinkCepSql4 {

    public static void main(String[] args) {
        SqlEnv sqlEnv = SqlEnv.getInstance();
        sqlEnv.createTable("04-cep-ticker-kafka-source.sql");
        sqlEnv.sendData("04-cep-ticker-data.txt");
        sqlEnv.query("04-cep-ticker-query.sql");
    }

}
