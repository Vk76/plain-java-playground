package com.domain;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.AdminClientConfig;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaDemoAdmin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        Admin admin = Admin.create(properties);
        var listTopicsResult = admin.listTopics();
        var listTopicsFuture = listTopicsResult.names();
        var listings = listTopicsFuture.get();
        System.out.println(listings);
    }
}
