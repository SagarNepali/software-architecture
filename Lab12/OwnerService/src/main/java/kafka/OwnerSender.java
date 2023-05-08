package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OwnerSender {

    @Autowired
    KafkaTemplate<String, OwnerRecord> kafkaTemplate;

    private static final String TOPIC = "ownertopic";

    public void send(OwnerRecord ownerRecord){
        kafkaTemplate.send(TOPIC, ownerRecord);
    }
}
