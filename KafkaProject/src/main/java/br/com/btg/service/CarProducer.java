package br.com.btg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.btg.controller.CarDTO;

@Service
public class CarProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(CarProducer.class);
	private final String topic;
	private final KafkaTemplate<String, CarDTO> kafkaTemplate;
	
	public CarProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, CarDTO> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(CarDTO carDTO) {
		kafkaTemplate.send(topic,carDTO).addCallback(
				success -> logger.info("Mensagem enviada!"),
				failure -> logger.info("Mensagem de falha" + failure.getMessage()));
	}
	
}
