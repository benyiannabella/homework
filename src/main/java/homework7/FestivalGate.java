package homework7;

import lombok.Getter;

import java.util.LinkedList;

@Getter
public class FestivalGate {
    private final int gateNr = 1;

    //iterate till 1000 and create new festival attendee threads;
    //set thread priority based on the ticket type and make the threads runnable/start;
    public void enterGate(LinkedList<String> gateAttendees) {

        for (int i = 0; i < 1000; i++) {
            FestivalAttendeeThread newAttendee = new FestivalAttendeeThread(TicketType.randomTicketType(), this);
            newAttendee.setName("Attendee" + i);
            if (TicketType.randomTicketType().equals(TicketType.FULL_VIP.toString())) {
                newAttendee.setPriority(5);
            } else if (TicketType.randomTicketType().equals(TicketType.ONE_DAY_VIP.toString())) {
                newAttendee.setPriority(4);
            } else if (TicketType.randomTicketType().equals(TicketType.FREE_PASS.toString())) {
                newAttendee.setPriority(3);
            } else if (TicketType.randomTicketType().equals(TicketType.FULL.toString())) {
                newAttendee.setPriority(2);
            } else {
                newAttendee.setPriority(1);
            }

            newAttendee.start();

            addAttendee(newAttendee, gateAttendees);
            sleepAttendeeTh();
        }
    }

    //add the newly created thread's randomly generated ticket type to a String List;
    public void addAttendee(FestivalAttendeeThread newAttendee, LinkedList<String> gateAttendees) {
        synchronized (gateAttendees) {
            gateAttendees.add(newAttendee.toString());
        }

        System.out.println(newAttendee.getName() + ": Ticket type - " + newAttendee.getTicketType()
                + newAttendee.getFestivalGate().toString() + ", proirity - " + newAttendee.getPriority());

    }

    //put the thread to spleep for 2 seconds;
    public void sleepAttendeeTh() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return ", gate - " + gateNr;
    }
}
