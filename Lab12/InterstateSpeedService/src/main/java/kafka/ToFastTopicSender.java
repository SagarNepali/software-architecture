package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ToFastTopicSender {

    @Autowired
    KafkaTemplate<String, Runner> kafkaTemplate;

    private static final String TO_FAST_TOPIC = "tofasttopic";

    public void send(Runner runner){
        kafkaTemplate.send(TO_FAST_TOPIC, runner);
    }
}
