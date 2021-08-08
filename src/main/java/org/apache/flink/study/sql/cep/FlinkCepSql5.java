package org.apache.flink.study.sql.cep;

import org.apache.flink.study.util.SqlEnv;

public class FlinkCepSql5 {

    public static void main(String[] args) {
        SqlEnv sqlEnv = SqlEnv.getInstance();
        sqlEnv.createTable("05-cep-ticker-kafka-source.sql");
        sqlEnv.sendData("05-cep-ticker-data.txt");
        sqlEnv.query("05-cep-ticker-query.sql");
    }

}
