package io.pkgonan.kafka.sample.test.service

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class TestService {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    // Fixme : Change Topic
    // Fixme : Change Key & Value of ConsumerRecord<Any, Any> -> ConsumerRecord<Key, Envelope>
    @KafkaListener(topics = ["test-topic"])
    fun handle(record: ConsumerRecord<Any, Any>) {
        logger.info("Record : $record")
    }
}