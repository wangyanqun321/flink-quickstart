package org.apache.flink.study.util;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static String read(String pathname) {
        File file = new File(pathname);
        StringBuilder result = new StringBuilder();
        try {
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String s;
            //使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                result.append("\n").append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static List<String> readLine(String pathname) {
        File file = new File(pathname);
        List<String> data = new ArrayList<>();
        try {
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String s;
            //使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                data.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
