# Trade Instructions Svc - Exercise I-2500

- [Kafka Quickstart](https://kafka.apache.org/quickstart)

```bash
curl -X POST http://localhost:8080/api/trade/json \
  -F "file=@trade.json"

docker compose exec broker bash
cd opt/kafka/
bin/kafka-console-consumer.sh --topic instructions.outbound --from-beginning --bootstrap-server localhost:9092
```


**Objective:** 
Design & implement a Spring Boot microservice:

- [X] Accepts trade instructions either via file upload or Kafka message.
- [X] Converts the input into a canonical format.
- [X] Applies transformation logic to sensitive fields.
- [X] Converts the canonical format into an accounting platform-specific JSON.
- [X] Publishes the final JSON to a Kafka topic.
- [ ] Uses in-memory storage for intermediate processing.
- [ ] Ensures security and performance best practices.

## Concepts Reviewed
- Canonical Data Models
- Bean validation via Jakarta
- Instant vs. LocalDateTime

## Questions
- Difference b/w `platform_id` vs. `account_no`?
  - ```json
    {
        "platform_id": "ACCT123",
        "trade": {
            "account_no": "****1234",
            ...
        }
    }
    ```
- Purpose of retrieving from in-memory buffer? Intent can inform better key choice.





_____

## Challenges Encountered

1. **Context:** Attempting to publish PlatformTrade to `instructions.outbound` Kafka topic<br>**Issue:** [Request processing failed: org.apache.kafka.common.errors.SerializationException: Can't convert value of class ex.microsvc.banking.tradeinstructions.model.PlatformTrade to class org.apache.kafka.common.serialization.StringSerializer specified in value.serializer] with root cause<br>**Obs:** toString() methods have been implemented on all custom data models
    - **Solution:** props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    - **!REF**
1. **Context:** <br>**Issue:** <br>**Obs:** 
    - **Solution:** 
    - **!REF**
1. **Context:** <br>**Issue:** <br>**Obs:** 
    - **Solution:** 
    - **!REF**
1. **Context:** <br>**Issue:** <br>**Obs:** 
    - **Solution:** 
    - **!REF**