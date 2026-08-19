import java.io.*; 
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class GradeAnalyzer {
 
    static int invalidcount = 0;
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        
        String file = filename;
        String line;

        ArrayList<Integer> scorenums = new ArrayList<Integer>();

        int i = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            
            while ((line = reader.readLine()) != null) {

                line = line.trim();
    
                if (line.isEmpty()) {
                    continue;
                }
                
                try {
                    int newint = Integer.parseInt(line);
                    scorenums.add(newint);
                } 
                
                catch (NumberFormatException e) {

                    System.out.println("Skipping invalid value: " + line);
                    invalidcount++;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }  


        return scorenums;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> lscores) {
        //get value from list
        //add to toal var
        //divide by 10

        if (lscores.isEmpty()){
            return 0.0;
        }

        double sum = 0;

        for (int i = 0; i < lscores.size(); i++){

            double temp = lscores.get(i);
            sum += temp;

        }

        double average = sum/lscores.size();

        return average;
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {

        //count number of scores in each grade cat
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int i = 0; i < scores.size(); i++) {
           
            int score = scores.get(i);

            if (score >= 90) {
                countA++;
            } 

            else if (score >= 80) {
                countB++;
            } 

            else if (score >= 70) {
                countC++;
            } 

            else if (score >= 60) {
                countD++;
            } 

            else {
                countF++;
            }
        }


        //write report to new file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            writer.write("Grade Analysis Report");
            writer.newLine();

            writer.write("Total scores processed: " + scores.size());
            writer.newLine();

            writer.write(String.format("Average score: %.2f", avg));
            writer.newLine();

            writer.write("Highest score: " + high);
            writer.newLine();

            writer.write("Lowest score: " + low);
            writer.newLine();
            writer.newLine();
            writer.newLine();

            writer.write("Grade distribution:");
            writer.newLine();

            writer.write("A (90-100): " + countA);
            writer.newLine();

            writer.write("B (80-89): " + countB);
            writer.newLine();

            writer.write("C (70-79): " + countC);
            writer.newLine();

            writer.write("D (60-69): " + countD);
            writer.newLine();

            writer.write("F (below 60): " + countF);
            writer.newLine();

            writer.write("Invalid lines skipped: " + invalidcount);
            writer.newLine();

        } 
        
        catch (IOException e) {
            System.out.println("Could not write report: " + e.getMessage());
        }

        //print the same info to the terminal
        System.out.println("Grade Analysis Report");
        System.out.println("Total scores processed: " + scores.size());

        System.out.println(String.format("Average score: %.2f", avg));
        System.out.println("Highest score: " + high);
        System.out.println("Lowest score: " + low);
        System.out.println();


        System.out.println("Grade distribution:");
        System.out.println("A (90-100): " + countA);
        System.out.println("B (80-89): " + countB);
        System.out.println("C (70-79): " + countC);
        System.out.println("D (60-69): " + countD);
        System.out.println("F (below 60): " + countF);
        System.out.println("Invalid lines skipped: " + invalidcount);

    }

    public static void main(String[] args) {
        // Step 1: read scores from file
        // Step 2: calculate statistics
        // Step 3: write and print report

        String file = "scores.txt";

        String outputf = "report.txt";

        ArrayList<Integer> scorelist = readScores(file);

        double average = calculateAverage(scorelist);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int i = 0; i < scorelist.size(); i++) {
            int current = scorelist.get(i);

            if (current > highest) {
                highest = current;
            }
            if (current < lowest) {
                lowest = current;
            }
        }



        writeReport(scorelist, average, highest, lowest, outputf);
    
    } 
} 