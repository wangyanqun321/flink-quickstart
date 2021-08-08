package org.apache.flink.study.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class MyKafkaProducer {

    public static void main(String[] args) {
        sendData("C:\\Users\\Administrator\\IdeaProjects\\flink-quickstart\\src\\main\\resources\\data\\04-cep-ticker-data.txt");
    }

    public static void sendData(String filePath) {
        //配置信息
        Properties props = new Properties();
        //kafka服务器地址
        props.put("bootstrap.servers", "node1:9092");
        //设置数据key和value的序列化处理类
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);
        //创建生产者实例
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        for(String data : FileReader.readLine(filePath)) {
            ProducerRecord<String, String> record = new ProducerRecord<>("test", data);
            //发送记录
            producer.send(record);
        }
        producer.close();
    }

}
