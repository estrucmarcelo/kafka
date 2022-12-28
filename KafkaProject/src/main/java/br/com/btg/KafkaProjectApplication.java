package br.com.btg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
public class KafkaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProjectApplication.class, args);
	}

}
