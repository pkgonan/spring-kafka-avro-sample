# Spring Kafka Gradle Sample
- Schema Registry
    - Avro

## How to use ?
- First, Change topic name
    ```
      @KafkaListener(topics = ["test-topic"])
    ```
    ```
      subject("test-topic-key", "src/main/avro")
      subject("test-topic-value", "src/main/avro")
    ```
- Second, Change schema registry url
    ```
      url.set("http://localhost:8081")
    ```

- Third, Download schema and generate java code using gradle build
    ```
      gradle build
    ```

- Fourth, Change ConsumerRecord key & value class to generated java class
    ```
      fun handle(record: ConsumerRecord<Any, Any>)
    ```