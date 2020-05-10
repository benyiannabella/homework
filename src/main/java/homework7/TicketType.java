package homework7;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//create ticket types;
public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    //add the enum values to a String list;
    public static List<String> createTicketList() {
        return Arrays.stream(TicketType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    //pick a ticket type string randomly from the list;
    public static String randomTicketType() {
        List<String> ticketList = createTicketList();
        return ticketList.get(new Random().nextInt(ticketList.size()));
    }

}