package homework7;

import java.util.LinkedList;

public class FestivalMain {
    public static void main(String[] args) {
        LinkedList<String> gateAttendees = new LinkedList<>();
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate, gateAttendees);
        statsThread.start();
        gate.enterGate(gateAttendees);
    }
}
