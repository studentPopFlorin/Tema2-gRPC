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

    public String returnZodiacForBirthDate(String birthDate, List<ZodiacDetails> zodiacArray){
        int birthDateDay=Integer.parseInt(birthDate.split("/")[1]);
        int birthDateMonth=Integer.parseInt(birthDate.split("/")[0]);
        for(int index=0;index<zodiacArray.size();index++) {

            int zodiacStartDateDay = Integer.parseInt(zodiacArray.get(index).getStartDate().split("/")[1]);
            int zodiacStartDateMonth = Integer.parseInt(zodiacArray.get(index).getStartDate().split("/")[0]);
            int zodiacEndDateDay = Integer.parseInt(zodiacArray.get(index).getEndDate().split("/")[1]);
            int zodiacEndDateMonth = Integer.parseInt(zodiacArray.get(index).getEndDate().split("/")[0]);

            if(birthDateMonth>zodiacStartDateMonth && birthDateMonth<zodiacEndDateMonth)
            {
                return zodiacArray.get(index).getName();
            }else if(birthDateMonth==zodiacStartDateMonth && birthDateDay>=zodiacStartDateDay)
            {
                return zodiacArray.get(index).getName();
            } else if(birthDateMonth==zodiacEndDateMonth && birthDateDay<=zodiacEndDateDay){
                return zodiacArray.get(index).getName();
            }
        }
        return "";
    }
}
