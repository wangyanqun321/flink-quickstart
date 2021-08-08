package org.apache.flink.study.util;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

public class SqlEnv {

    private StreamExecutionEnvironment env;

    private StreamTableEnvironment tableEnv;

    private final static String path = "/Users/Administrator/IdeaProjects/flink-quickstart/src/main/resources/data/";

    private SqlEnv() {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
        this.env = env;
        this.tableEnv = tableEnv;
    }

    public static SqlEnv getInstance() {
        return new SqlEnv();
    }

    public void createTable(String ddlFileName) {
        String sql = readSql(ddlFileName);
        tableEnv.executeSql(sql);
    }

    public void query(String sqlFileName) {
        String sql = readSql(sqlFileName);
        Table table = tableEnv.sqlQuery(sql);
        tableEnv.toAppendStream(table, Row.class).print();
        try {
            env.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void queryToRetractStream(String sqlFileName) {
        String sql = readSql(sqlFileName);
        Table table = tableEnv.sqlQuery(sql);
        tableEnv.toRetractStream(table, Row.class).print();
        try {
            env.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void sendData(String fileName) {
        new Thread(() -> {
            System.out.println("准备发送数据");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MyKafkaProducer.sendData(path + fileName);
            System.out.println("发送完成");
        }).start();
    }

    public String readSql(String fileName) {
        return FileReader.read(path + fileName);
    }

}
