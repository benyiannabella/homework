package homework7;

import lombok.Getter;

import java.util.Random;

@Getter
public class FestivalGate {
    private String gateNumber = randomGateNum();

    public String randomGateNum() {
       String[] gateNumbers={"1", "2", "3"};
       String gateNum = gateNumbers[new Random().nextInt(gateNumbers.length)];
        return gateNum;
    }
}
