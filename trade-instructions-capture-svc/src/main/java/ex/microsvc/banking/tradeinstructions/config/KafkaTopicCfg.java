package ex.microsvc.banking.tradeinstructions.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicCfg {

    @Bean
    public NewTopic instructionsOutboundTopic() {
        return TopicBuilder.name("instructions.outbound").build();
    }
}
