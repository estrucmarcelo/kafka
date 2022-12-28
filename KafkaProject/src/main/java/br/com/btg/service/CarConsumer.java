package br.com.btg.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.btg.controller.CarDTO;

@Component
public class CarConsumer {

	
	private static final Logger logger = LoggerFactory.getLogger(CarConsumer.class);
	
	@Value(value = "${topic.name}")
	private  String topic;
	
	@Value(value = "${spring.kafka.consumer.group-id}")
	private String groupId;
	
	
	@KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, CarDTO> payload){
		logger.info("Tópico: {}", topic);
		logger.info("key: {}", payload.key());
		//logger.info("Headers: {}", payload.headers());
		logger.info("Partion: {}", payload.partition());
		logger.info("Order: {}", payload.value());

    }
	
	
}
