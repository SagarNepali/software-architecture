package kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @Autowired
    OwnerSender ownerSender;

    @Autowired
    OwnerService ownerService;

    @KafkaListener(topics = {"tofasttopic"})
    public void receive(@Payload Runner runner,
                        @Headers MessageHeaders headers) {
        OwnerRecord record = new OwnerRecord(runner.licensePlate, String.valueOf(runner.getSpeed()),
                ownerService.findByLicensePlate(runner.licensePlate));
        ownerSender.send(record);
        System.out.println("message: "+record);
    }

}