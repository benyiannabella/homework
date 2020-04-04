package homework7;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;

@Getter
@AllArgsConstructor
public class FestivalAttendeeThread implements Runnable {
    private TicketType ticketType;
    private FestivalGate gate;
    LinkedList<String> gateAttendees;


    @Override
    public void run() {
        synchronized (gateAttendees) {
            gateAttendees.add();
        }
    }

    public static void sleepAttendee() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
