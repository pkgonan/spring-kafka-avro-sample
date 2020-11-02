package io.pkgonan.kafka.sample.test.service

import mu.KLogging
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class TestService {

    companion object : KLogging()

    // Fixme : Change Topic
    // Fixme : Change Key & Value of ConsumerRecord<Any, Any>
    @KafkaListener(topics = ["test-topic"])
    fun handle(record: ConsumerRecord<Any, Any>) {
        logger.info { "Record : $record" }
    }
}