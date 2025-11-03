package ex.microsvc.banking.tradeinstructions.service;

import ex.microsvc.banking.tradeinstructions.model.CanonicalTrade;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TradeSvc {

    private final Map<Integer, CanonicalTrade> buffer;

    private final KafkaPublisherSvc kafkaPublisher;

    public TradeSvc(KafkaPublisherSvc kafkaPublisher) {
        this.kafkaPublisher = kafkaPublisher;
        this.buffer = new ConcurrentHashMap<>();
    }

    public void processTrade(CanonicalTrade trade) {
        this.buffer.put(trade.hashCode(), trade);
        this.kafkaPublisher.publishToInstructionsOutbound(trade);
    }
}
