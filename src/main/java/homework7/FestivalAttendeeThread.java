package homework7;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

//class for attendee threads
public class FestivalAttendeeThread extends Thread {
    private String ticketType;
    private FestivalGate festivalGate;


    @Override
    public String toString() {
        return ticketType;
    }
}

