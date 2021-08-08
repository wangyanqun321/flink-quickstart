package org.apache.flink.study.sql.window;

import org.apache.flink.study.util.SqlEnv;

public class TumbleWindow {

    public static void main(String[] args) {
        SqlEnv env = SqlEnv.getInstance();
        env.createTable("tumble-window-kafka-source.sql");
        env.query("tumble-window-query.sql");
    }

}
