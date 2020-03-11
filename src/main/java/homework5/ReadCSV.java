package homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReadCSV {
    //create new comparator to sort athletes by final time (ski time + penalty seconds);
    Comparator<Athlete> compareTime =
            (athlete1, athlete2) -> athlete1.getTime2().compareTo(athlete2.getTime2());

    //method to read the csv file content and create athlete objects
    public List<Athlete> readAthleteFile(String fileName) {
        List<Athlete> athletes = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        //crete a file reader;
        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToFile)) {
            String line = bufferedReader.readLine();

            //iterate trough every line from the csv file;
            // and assign the comma delimited text as new object field values;
            while (line != null) {
                String[] element = line.split(",");
                Athlete athlete = new Athlete(Integer.parseInt(element[0]),
                        element[1], element[2], element[3],
                        element[4], element[5], element[6]);

                athletes.add(athlete);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return athletes;
    }

    //method to add the created objects to an Athlete list;
    public void addAthlete() {
        WinnersDirectory directory = new WinnersDirectory();
        String fileName = "athlete";
        ReadCSV reader = new ReadCSV();
        List<Athlete> athletes = reader.readAthleteFile(fileName);

        //iterate trough the Athlete list;
        for (Athlete athlete : athletes) {
            //set the time format for the athlete skiing time;
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            //convert the athlete skying time into Time object
            LocalTime time = LocalTime.parse(athlete.getTime());
            int penalty = 0;
            //concatenate the range strings into one and convert it into char array;
            String range = athlete.getsRange1() + athlete.getsRange2() + athlete.getsRange3();
            char[] rangePenalty = range.toCharArray();
            //iterate trough the char array
            // and assign value +10 to the penalty variable if athlete missed the shooting target;
            for (char character : rangePenalty) {
                if (character != 'x') {
                    penalty += 10;
                }
            }

            //add the penalty seconds to the skiing time and assign the result to a string  variable;
            //assign this new string variable value to the time2 Athlete field;
            String newTime = timeFormatter.format(time.plusSeconds(penalty));
            athlete.setTime2(newTime);
            athlete.setPenalty(penalty);
        }

        //create new Athlete list;
        List<Athlete> newAthletes;
        //assign to this new list the values of first list
        // than sort the list by the time2 values by using the Comparator compare method;
        newAthletes = athletes;
        newAthletes.sort(compareTime);

        //iterate through the new list and display the competition final results;
        for (Athlete newAthlete : newAthletes) {

            if (newAthlete == newAthletes.get(0)) {
                System.out.println("Winner - " + newAthlete.getAthleteNumber() + ". " + newAthlete.getAthleteName() + ", "
                        + newAthlete.getCountryCode() + ", " + newAthlete.getTime2() + " "
                        + "(" + newAthlete.getTime() + " + " + newAthlete.getPenalty() + ")");
            } else if (newAthlete == newAthletes.get(1)) {
                System.out.println("Runner-up - " + newAthlete.getAthleteNumber() + ". " + newAthlete.getAthleteName() + ", "
                        + newAthlete.getCountryCode() + ", " + newAthlete.getTime2() + " "
                        + "(" + newAthlete.getTime() + " + " + newAthlete.getPenalty() + ")");
            } else if (newAthlete == newAthletes.get(2)) {
                System.out.println("Third Place - " + newAthlete.getAthleteNumber() + ". " + newAthlete.getAthleteName() + ", "
                        + newAthlete.getCountryCode() + ", " + newAthlete.getTime2() + " "
                        + "(" + newAthlete.getTime() + " + " + newAthlete.getPenalty() + ")");
            }

            //call write method to write results on file;
            directory.writeFile("Winner - " + newAthletes.get(0).toString() +
                    "\n" + "Runner-up - " + newAthletes.get(1).toString() +
                    "\n" + "Third Place - " + newAthletes.get(2).toString());
        }
    }
}

