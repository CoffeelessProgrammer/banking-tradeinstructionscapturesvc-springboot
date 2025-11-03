package ex.microsvc.banking.tradeinstructions.service;

import ex.microsvc.banking.tradeinstructions.model.CanonicalTrade;
import ex.microsvc.banking.tradeinstructions.model.PlatformTrade;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisherSvc {

    private final KafkaTemplate<String, PlatformTrade> kafkaTemplate;

    public KafkaPublisherSvc(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishToInstructionsOutbound(CanonicalTrade trade) {
        this.kafkaTemplate.send(
                "instructions.outbound",
                PlatformTrade.fromCanonicalTrade(trade)
        );
    }
}
