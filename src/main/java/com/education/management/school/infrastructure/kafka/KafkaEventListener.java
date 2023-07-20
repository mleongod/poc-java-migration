package com.education.management.school.infrastructure.kafka;

import com.education.management.shared.infrastructure.kafka.KafkaProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventListener {
  @KafkaListener(topics = KafkaProducer.TEST_TOPIC)
  public void receiveMessage(String message) {
    System.out.println("Received message: " + message);
  }
}
