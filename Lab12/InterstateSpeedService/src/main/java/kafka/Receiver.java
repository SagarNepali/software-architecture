package kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @Autowired
    ToFastTopicSender toFastTopicSender;

    @KafkaListener(topics = {"cameratopic1" , "cameratopic2"})
    public void receive(@Payload SensorRecord sensorRecord,
                        @Headers MessageHeaders headers) {
        Double speed = calculateSpeed(sensorRecord.getSecond());
        System.out.println("Speed of "+sensorRecord.licencePlate+" = "+speed+ " mph");
        if(speed > 72.00) {
            toFastTopicSender.send(new Runner(sensorRecord.licencePlate, speed));
        }
    }

    private Double calculateSpeed(int second) {
        return (0.5 / second) * 3600;
    }

}