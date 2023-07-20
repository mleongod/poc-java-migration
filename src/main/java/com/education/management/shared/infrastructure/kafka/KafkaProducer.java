package com.education.management.shared.infrastructure.kafka;


import java.text.MessageFormat;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducer {

  public static final String TEST_TOPIC = "test-topic";
  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message) {
    try{
      kafkaTemplate.send(TEST_TOPIC, message);
    } catch (Exception exception) {

      throw new RuntimeException(MessageFormat.format(
          "Error while publishing event to topic: {}. : {}",
          TEST_TOPIC,
          exception.getMessage(),
          exception)
      );
    }
  }
}
