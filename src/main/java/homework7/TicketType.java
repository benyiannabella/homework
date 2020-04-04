package homework7;

import java.util.Random;

public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    public static TicketType getTicketType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
