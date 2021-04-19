package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Helper {
    public void getZodiacFromFile(List<ZodiacDetails> zodiacArray){
        try {
            File file = new File("zodiac.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                ZodiacDetails currentZodiac;
                String line = myReader.nextLine();
                String[] details=line.split(";");
                currentZodiac=new ZodiacDetails(details[0],details[1],details[2]);
                zodiacArray.add(currentZodiac);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
