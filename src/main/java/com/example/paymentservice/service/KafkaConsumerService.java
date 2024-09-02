package com.example.paymentservice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class KafkaConsumerService {

    private static final String FILE_PATH = "P:/kafka/my-files/my-file.txt";

    @KafkaListener(topics = "new-topic", groupId = "order-processing-group")
    public void consume(ConsumerRecord<String, String> record, Acknowledgment acknowledgment){
        String message = record.value();
        System.out.println("Consumed message: "+ message);

        appendToFile(message);
    }

    private void appendToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
