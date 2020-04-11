package homework7;

import lombok.AllArgsConstructor;

import java.util.LinkedList;

@AllArgsConstructor
//class for creating statistic thread;
public class FestivalStatisticsThread extends Thread {

    private FestivalGate festivalGate;
    private LinkedList<String> gateAttendees = new LinkedList<>();

    //override run method of the Thread class;
    //continuously gather data from gate and sleep 5 seconds after each run;
    @Override
    public void run() {
        while (true) {
            if (gateAttendees.size() != 0) {
                long entered = gateAttendees.size();
                System.out.println(entered + " people entered to the festival.");
                long vip = gateAttendees.stream().filter(x -> x.equals(TicketType.FULL_VIP.toString())).count();
                System.out.println(vip + " people have " + TicketType.FULL_VIP.toString() + " ticket.");
                long full = gateAttendees.stream().filter(x -> x.equals("FULL")).count();
                System.out.println(full + " people have " + TicketType.FULL.toString() + " ticket.");
                long oneVIP = gateAttendees.stream().filter(x -> x.equals(TicketType.ONE_DAY_VIP.toString())).count();
                System.out.println(oneVIP + " people have " + TicketType.ONE_DAY_VIP.toString() + " ticket.");
                long oneDay = gateAttendees.stream().filter(x -> x.equals(TicketType.ONE_DAY.toString())).count();
                System.out.println(oneDay + " people have " + TicketType.ONE_DAY.toString() + " ticket.");
                long free = gateAttendees.stream().filter(x -> x.equals(TicketType.FREE_PASS.toString())).count();
                System.out.println(free + " people have " + TicketType.FREE_PASS.toString() + " ticket.");
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
