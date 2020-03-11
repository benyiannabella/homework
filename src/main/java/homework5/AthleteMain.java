package homework5;

public class AthleteMain {

    public static void main(String[] args) {
        ReadCSV reader = new ReadCSV();

        // call the addAthlete method to create the new list and add athletes to the list;
        //and print the final results on the Console and into 2020 Biathlon WR medalists.txt file on drive C;
        reader.addAthlete();
    }
}
