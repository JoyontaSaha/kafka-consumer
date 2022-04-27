package com.joyontasaha.kafkaconsumer.service;

import com.joyontasaha.kafkaconsumer.config.KafkaConsumerConfig;
import com.joyontasaha.kafkaconsumer.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

    private static final String TOPIC = "Kafka_Example";

    private static final String TOPIC_JSON = "Kafka_Example_Json";

    @KafkaListener(topics = TOPIC, groupId = KafkaConsumerConfig.GROUP_STRING, containerFactory = "kafkaListenerContainerFactory")
    public void getMessage(String message){
       log.info("listen string message :: {}",message);

    }

    @KafkaListener(topics = TOPIC_JSON, groupId = KafkaConsumerConfig.GROUP_JSON, containerFactory = "userKafkaListenerContainerFactory")
    public void getJsonMessage(User user){
        log.info("listen json message :: {}",user);

    }

}
