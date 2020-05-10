package homework5;

import java.util.Objects;

public class Athlete {
    //athlete fields
    private int athleteNumber; //athlete competition number
    private String athleteName; // athlete name;
    private String countryCode; //athlete country code;
    private String time; // athlete skiing time;
    private String sRange1; // athlete first shooting results;
    private String sRange2; // athlete second irst shooting results;
    private String sRange3; // athlete third shooting results;
    private String time2; // new time field to save the final time, use it to sort;
    private int penalty; // penalty seconds calculated from the shooting results;

    //athlete constructor
    public Athlete(int athleteNumber, String athleteName, String countryCode, String time, String sRange1, String sRange2, String sRange3) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.time = time;
        this.sRange1 = sRange1;
        this.sRange2 = sRange2;
        this.sRange3 = sRange3;
    }

    //Getters
    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getTime() {
        return time;
    }

    public String getsRange1() {
        return sRange1;
    }

    public String getsRange2() {
        return sRange2;
    }

    public String getsRange3() {
        return sRange3;
    }

    public String getTime2() {
        return time2;
    }

    public int getPenalty() {
        return penalty;
    }

    //Setters
    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    //override Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Athlete)) return false;
        Athlete athlete = (Athlete) o;
        return getTime2().equals(athlete.getTime2());
    }

    //override hashcode
    @Override
    public int hashCode() {
        return Objects.hash(time2);
    }

    @Override
    public String toString() {
         return athleteNumber + ". " + athleteName + ", " + countryCode + ", " + time2 + " "
                    + "(" + time + " + " + penalty + ")";
    }

}
