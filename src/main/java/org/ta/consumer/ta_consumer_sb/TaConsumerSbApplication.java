package org.ta.consumer.ta_consumer_sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;

@SpringBootApplication
public class TaConsumerSbApplication {

	private static final Logger log = LoggerFactory.getLogger(TaConsumerSbApplication.class);


	public static void main(String[] args) {
		String startTime = Instant.now().toString();

        log.info("starting at " + startTime);
		SpringApplication.run(TaConsumerSbApplication.class, args);

		String endTime = Instant.now().toString();
		log.info("finishing at " + endTime);


	}
	/**
	 * method to read item from a rabbitmq queue
	 */
	@RabbitListener(queues = "${rabbitmq.queue.name}")
	public void receiveMessage(String message) {
		log.info("Received message: " + message);
	}
}
