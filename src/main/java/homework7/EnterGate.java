package homework7;

public class EnterGate {
    FestivalGate gate = new FestivalGate();
    TicketType ticketType = TicketType.getTicketType();
    FestivalAttendeeThread attendeeThread = new FestivalAttendeeThread(ticketType, gate);
    FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);

    public void enterGate() {
        for (int i = 0; i<=100; i++) {
            Thread attendee = new Thread(attendeeThread);
            attendee.setName("Attendee "+ i);
            attendee.start();
        }

        Thread statistic = new Thread(statsThread);
        statistic.start();
    }


}
