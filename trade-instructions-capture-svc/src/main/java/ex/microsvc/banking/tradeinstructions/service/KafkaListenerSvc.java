package ex.microsvc.banking.tradeinstructions.service;

import ex.microsvc.banking.tradeinstructions.model.CanonicalTrade;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerSvc {

    private final TradeSvc tradeService;

    public KafkaListenerSvc(TradeSvc tradeService) {
        this.tradeService = tradeService;
    }

    @KafkaListener(topics = "instructions.inbound", groupId = "uniqueId")
    void instructionInboundListener(CanonicalTrade trade) {
        // System.out.printf("Received trade: %s\n", trade);   // Testing purposes only
        this.tradeService.processTrade(trade);
    }
}
