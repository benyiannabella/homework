package homework7;

import java.util.LinkedList;

public class FestivalStatisticsThread implements Runnable {
    private FestivalGate gate;
    LinkedList<String> gateAttendees;

    public FestivalStatisticsThread(FestivalGate gate, LinkedList<String> gateAttendees) {
        this.gate = gate;
        this.gateAttendees = gateAttendees;
    }

    @Override
    public void run() {
        sleepStatsThread();
//        getGateData();
        synchronized (gateAttendees) {
            if (!gateAttendees.isEmpty()) {
                for (String attendee : gateAttendees) {
                    System.out.println(attendee);
                }
            } else {
                System.out.println("No data at the gate");
            }
        }
    }

    public static void sleepStatsThread() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static void getGateData() {
//
//        synchronized (gateAttendees) {
//            if (!attendees.isEmpty()) {
//                for (String attendee : attendees) {
//                    System.out.println(attendee);
//                }
//            } else {
//                System.out.println("No data at the gate");
//            }
//        }
//    }
}
