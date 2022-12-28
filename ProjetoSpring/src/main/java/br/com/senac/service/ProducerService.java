package br.com.senac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProducerService {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public void sendMessage(String message) {
		kafkaTemplate.send("str-topic",message).addCallback(
				success ->{
					log.info("Mensagem enviada com sucesso: {}",message);
					log.info("Partition: {}, Offset: {}", success.getRecordMetadata().partition(),
							success.getRecordMetadata().offset()
					);
					
				},
				error -> log.error("Deu problema no envio")
		);
		
	}
}
