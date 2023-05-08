package kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @KafkaListener(topics = {"ownertopic"})
    public void receive(@Payload OwnerRecord ownerRecord,
                        @Headers MessageHeaders headers) {
        System.out.println("Record: "+ownerRecord+ ", fee = $ "+feeCalculator(ownerRecord.getSpeed()));
    }

    private Integer feeCalculator(String speed) {
        Integer speedInInteger = (int) Double.parseDouble(speed);

        if(speedInInteger < 77 ){
            return 25;
        } else if (speedInInteger < 82) {
            return 45;
        } else if (speedInInteger < 90) {
            return 80;
        } else {
            return 125;
        }
    }


}