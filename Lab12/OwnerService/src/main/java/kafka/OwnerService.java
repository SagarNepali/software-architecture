package kafka;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OwnerService {

    private static final String AS = "AS";
    private static final String BS = "BS";
    private static final String CS = "CS";
    private static final String DS = "DS";
    private static final String ES = "ES";
    private static final String FS = "FS";
    private static final String GS = "GS";
    private static final String FAS = "FAS";
    private static final String FGS = "FGS";
    private static final String FBS = "FBS";

    private static final Map<String, String> owners = new HashMap<String, String>() {{
        put(AS, "HARRY MCGUIRE");
        put(BS, "TOM CRUISE");
        put(CS, "HAYDEN");
        put(DS, "BILL");
        put(ES, "OBAMA");
        put(FS, "OSAMA BIN LADEN");
        put(GS, "QUINCY");
    }};

    public String findByLicensePlate(String licensePlate) {
        String owner = owners.get(licensePlate.substring(0,2));
        return owner == null ?
                "JOHN DOE" : owner;
    }
}
