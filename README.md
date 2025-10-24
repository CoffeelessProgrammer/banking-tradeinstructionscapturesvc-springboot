# Trade Instructions Svc - Exercise I-2500


```
curl -X POST http://localhost:8080/api/trade/json \
  -F "file=@test.json"
```

**Objective:** 
Design & implement a Spring Boot microservice:

- [X] Accepts trade instructions either via file upload or Kafka message.
- [X] Converts the input into a canonical format.
- [ ] Applies transformation logic to sensitive fields.
- [ ] Converts the canonical format into an accounting platform-specific JSON.
- [ ] Publishes the final JSON to a Kafka topic.
- [ ] Uses in-memory storage for intermediate processing.
- [ ] Ensures security and performance best practices.

## Concepts Learned
- Canonical Data Models
- Bean validation via Jakarta
- Instant vs. LocalDateTime
