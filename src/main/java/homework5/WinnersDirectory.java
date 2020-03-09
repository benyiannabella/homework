package homework5;

import java.io.*;

public class WinnersDirectory {

    public void writeFile(String winnersList) {

        //define the path where the document to be created;
        String path = "c:/";
        String directoryName = path.concat(this.getClass().getName());
        String fileName = "2020 Biathlon WR medalists.txt";

        //if doesn't exists, create directory;
        File directory = new File(directoryName);
        if (! directory.exists()) {
            directory.mkdir();
        }

        //create file inside directory;
        File file = new File(directoryName + "/" + fileName);
        try{
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(winnersList);
            bufferedWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }

    }


}
